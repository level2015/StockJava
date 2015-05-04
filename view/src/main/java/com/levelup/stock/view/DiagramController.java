package com.levelup.stock.view;

import com.levelup.stock.model.BasicColumnChart;
import com.levelup.stock.model.PieChartTest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/diagram")
public class DiagramController {
//    Круговая диаграмма и передача данных для ее отрисовки
    @RequestMapping(value ="/pieChart", method = RequestMethod.GET)
    public String viewPieChart(Model model) {
        return "pieChart.page";
    }

    @RequestMapping(value ="/pieChart/data", produces = "application/json", method = RequestMethod.POST)
    public @ResponseBody List<PieChartTest> getDataListForPieChart(@RequestParam("dateBegin") String dateBegin,
                                                        @RequestParam("dateEnd") String dateEnd) {
        List<PieChartTest> dataList = new ArrayList<PieChartTest>();
        dataList.add(new PieChartTest("McDonald's", 30.5f));
        dataList.add(new PieChartTest("King Burger", 25.5f));
        dataList.add(new PieChartTest("Fufelok", 40.5f));
        dataList.add(new PieChartTest("Others", 3.5f));
        return dataList;
    }

    //    Столбчатая диаграмма и передача данных для ее отрисовки
    @RequestMapping(value ="/basicColumnChart", method = RequestMethod.GET)
    public String viewBasicColumn(Model model) {
        return "basicColumnChart.page";
    }

    @RequestMapping(value ="/basicColumnChart/data", produces = "application/json", method = RequestMethod.POST)
    public @ResponseBody List<BasicColumnChart> getDataListForBasicColumn(@RequestParam("dateBegin") String dateBegin,
                                                        @RequestParam("dateEnd") String dateEnd) {
        List<BasicColumnChart> dataList = new ArrayList<BasicColumnChart>();
        List<Integer> dataForChart = new ArrayList();
        dataForChart.add(10);
        dataForChart.add(12);
        dataForChart.add(16);
        dataForChart.add(18);
        dataForChart.add(14);
        dataForChart.add(40);
        dataForChart.add(70);
        dataForChart.add(20);
        dataForChart.add(30);
        dataForChart.add(90);
        dataForChart.add(100);
        dataForChart.add(15);

        dataList.add(new BasicColumnChart("McDonald's", dataForChart));
        dataList.add(new BasicColumnChart("King Burger", dataForChart));
        dataList.add(new BasicColumnChart("Fufelok", dataForChart));
        dataList.add(new BasicColumnChart("Others", dataForChart));
        return dataList;
    }



}
