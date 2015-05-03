package com.levelup.stock.view;

import com.levelup.stock.model.pieChartTest;
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

    @RequestMapping(value ="/pieChart", method = RequestMethod.GET)
    public String viewName(Model model) {
        return "pieChart.page";
    }

    @RequestMapping(value ="/pieChart/data", produces = "application/json", method = RequestMethod.POST)
    public @ResponseBody List<pieChartTest> getDataList(@RequestParam("dateBegin") String dateBegin,
                                                        @RequestParam("dateEnd") String dateEnd) {
        List<pieChartTest> dataList = new ArrayList<pieChartTest>();
        dataList.add(new pieChartTest("Vdaha", 10.5f));
        dataList.add(new pieChartTest("Stepanov", 5.5f));
        dataList.add(new pieChartTest("Ikonnikov", 4.5f));
        dataList.add(new pieChartTest("Others", 79.5f));
        return dataList;
    }
}
