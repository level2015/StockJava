package com.levelup.spring.dao.impl;

import com.levelup.spring.dao.ChartsRepository;
import com.levelup.stock.model.dto.LineChartDTO;
import com.levelup.stock.model.dto.LineChartZoom;
import com.levelup.stock.model.dto.PieChartData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class ChartsRepositoryImpl implements ChartsRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    //Рекомендуемый способ создания jdbcTemplate по документации Spring.
//    Можно не использовать если в файле конфигурации создать бин на jdbcTemplate
//    @Autowired
//    public void setDataSource(DataSource dataSource) {
//        this.jdbcTemplate = new JdbcTemplate(dataSource);
//    }

    @Override
    public List<PieChartData> getDataForPieChart(Long id, Long beginTime, Long endTime) {
        String sql = "SELECT symbol, count(symbol) as quantity FROM stocks.deal where date_format(closeTime, '%Y-%m-%d') "
                + "between " + "'" + new SimpleDateFormat("yyyy-MM-dd").format(beginTime) + "'"
                + " and " + "'" + new SimpleDateFormat("yyyy-MM-dd").format(endTime) + "'"
                + " and user_id=" + id.toString()
                + " group by symbol;";
        List<PieChartData> list = jdbcTemplate.query(sql, new RowMapper<PieChartData>() {
            @Override
            public PieChartData mapRow(ResultSet resultSet, int i) throws SQLException {
                PieChartData pieChartData = new PieChartData();
                pieChartData.setSymbol(resultSet.getString(1));
                pieChartData.setQuantity(resultSet.getLong(2));
                return pieChartData;
            }
        });
        return list;
    }

    @Override
    public void getDataForBasicColumnChart(Long id, Long beginTime, Long endTime) {

    }

    public List<LineChartZoom> getDataForLineChart(Long id, Long beginTime, Long endTime) {
        List<LineChartZoom> dataList = new ArrayList<LineChartZoom>();
        //Запрос на уникальный перечень типа сделок в период времени
        String sql = "SELECT DISTINCT symbol FROM stocks.deal where date_format(closeTime, '%Y-%m-%d') "
                + "between " + "'" + new SimpleDateFormat("yyyy-MM-dd").format(beginTime) + "'"
                + " and " + "'" + new SimpleDateFormat("yyyy-MM-dd").format(endTime) + "'"
                + " and user_id=" + id.toString() + " ;";

        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        for (Map row : rows) {
            LineChartZoom lineChartZoom = new LineChartZoom();
            lineChartZoom.setName((String) (row.get("symbol")));
            dataList.add(lineChartZoom);
        }
//Запрос на получение данных из БД
        sql = "SELECT symbol, sum(profit), date_format(closeTime, '%Y-%m-%d') FROM stocks.deal where date_format(closeTime, '%Y-%m-%d') "
                + "between " + "'" + new SimpleDateFormat("yyyy-MM-dd").format(beginTime) + "'"
                + " and " + "'" + new SimpleDateFormat("yyyy-MM-dd").format(endTime) + "'"
                + " and user_id=" + id.toString() + " group by date_format(closeTime, '%Y-%m-%d'), symbol;";

        List<LineChartDTO> listTransfer = jdbcTemplate.query(sql, new RowMapper<LineChartDTO>() {
            @Override
            public LineChartDTO mapRow(ResultSet resultSet, int i) throws SQLException {
                LineChartDTO lineChartDTO = new LineChartDTO();
                lineChartDTO.setSymbol(resultSet.getString(1));
                lineChartDTO.setProfit(new BigDecimal(resultSet.getDouble(2)).setScale(2, RoundingMode.UP).doubleValue());
                lineChartDTO.setDate(resultSet.getDate(3).getTime());
                return lineChartDTO;
            }
        });
//Подготовка данных для графика
        int counter = 0;
        int position = 0;
        boolean flag = false;
        for (long i = beginTime; i <= endTime; i += 24 * 60 * 60 * 1000) {
            dataList = setZeroForEachElement(dataList);
            if (counter<listTransfer.size()) {
                do {
                    if (listTransfer.get(counter).getDate() == i) {
                        dataList.get(getIndexOfElementByName(dataList, listTransfer.get(counter).getSymbol())).getData().set(position, new BigDecimal(listTransfer.get(counter).getProfit()).setScale(2, RoundingMode.UP).doubleValue());
                        flag = true;
                        counter++;
                    } else {
                        flag = false;
                    }
                } while (flag&&(counter<listTransfer.size()));
            }
            position++;
        }
        return dataList;
    }

    //Получение индекса объекта в коллекции по его имени
    private static int getIndexOfElementByName(List<LineChartZoom> dataList, String name) {
        for (LineChartZoom elem : dataList) {
            if (elem.getName().equals(name)) {
                return dataList.indexOf(elem);
            }
        }
        return -1;
    }

    //Заполнение нулями следующего элемента в коллекции, которая является полем объекта, для всех объектов в коллекции
    private static List<LineChartZoom> setZeroForEachElement(List<LineChartZoom> dataList) {
        for (LineChartZoom elem : dataList) {
            elem.getData().add(new BigDecimal(0).setScale(2, RoundingMode.UP).doubleValue());
        }
        return dataList;
    }
}
