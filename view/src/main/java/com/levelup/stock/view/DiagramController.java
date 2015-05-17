package com.levelup.stock.view;

import com.levelup.spring.service.ChartsService;
import com.levelup.stock.model.BasicColumnChart;
import com.levelup.stock.model.PieChartTest;
import com.levelup.stock.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/diagram")
@SessionAttributes("user")
public class DiagramController {
@Autowired
//    DealService dealService;
    ChartsService chartsService;

    //    О диаграммах
    @RequestMapping(value ="/about", method = RequestMethod.GET)
    public String viewAboutCharts(Model model) {
        return "charts.page";
    }

//    Круговая диаграмма и передача данных для ее отрисовки
    @RequestMapping(value ="/pieChart", method = RequestMethod.GET)
    public String viewPieChart(Model model) {
        return "pieChart.page";
    }

    @RequestMapping(value ="/pieChart/data", produces = "application/json", method = RequestMethod.POST)
    public @ResponseBody List<PieChartTest> getDataListForPieChart(@ModelAttribute("user") User user, @RequestParam("dateBegin") Long dateFrom,
                                                        @RequestParam("dateEnd") Long dateTo) {
//        List<PieChartTest> dataList = new ArrayList<PieChartTest>();
//        dataList.add(new PieChartTest("McDonald's", 30.5));
//        dataList.add(new PieChartTest("King Burger", 25.5));
//        dataList.add(new PieChartTest("Fufelok", 40.5));
//        dataList.add(new PieChartTest("Others", 3.5));
//        return dealService.getAllUniqe(user.getEmail(), dateFrom, dateTo);
        return chartsService.getPieChartValidData(user.getId(), dateFrom, dateTo);
    }

    //    Столбчатая диаграмма и передача данных для ее отрисовки
    @RequestMapping(value ="/basicColumnChart", method = RequestMethod.GET)
    public String viewBasicColumn(Model model) {
        return "basicColumnChart.page";
    }

    @RequestMapping(value ="/basicColumnChart/data", produces = "application/json", method = RequestMethod.POST)
    public @ResponseBody List<BasicColumnChart> getDataListForBasicColumn(@RequestParam("dateBegin") Long dateBegin,
                                                        @RequestParam("dateEnd") Long dateEnd) {
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
