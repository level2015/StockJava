package com.levelup.stock.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/welcome")
public class WelcomeController {

    @RequestMapping(value ="", method = RequestMethod.GET)
    public String viewWelcomePage(Model model) {
        return "welcome.page";
    }

    @RequestMapping(value ="/mainPage", method = RequestMethod.GET)
    public String viewMainPage(Model model) {
        return "main.page";
    }

}
