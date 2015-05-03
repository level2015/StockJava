package com.levelup.stock.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/diagram")
public class DiagramController {

    @RequestMapping(value ="/pieChart", method = RequestMethod.GET)
    public String saveName(Model model) {
        return "pieChart.page";
    }
}
