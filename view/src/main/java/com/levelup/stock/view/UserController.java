package com.levelup.stock.view;

import Pars.ParseCSV;
import com.levelup.spring.service.DealService;
import com.levelup.spring.service.UserService;
import com.levelup.stock.model.Deal;
import com.levelup.stock.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    DealService dealService;


    @RequestMapping(value = "/create", method = RequestMethod.POST)

    public String createUser(Model model,
                                @RequestParam String email,
                                @RequestParam String password,
                                @RequestParam String name) {

        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setName(name);
        userService.create(user);



        ParseCSV myParse = new ParseCSV();
        ArrayList<ArrayList<String>> pars = myParse.parseCSV("f://orders-example.csv");

        for(int i=0; i<pars.size();i++){
            Deal deal = new Deal();
            int j=-1;
            deal.setType(pars.get(i).get(++j));
            deal.setTicket(pars.get(i).get(++j));
            deal.setSymbol(pars.get(i).get(++j));
            deal.setLots(pars.get(i).get(++j));
            deal.setBuySell(pars.get(i).get(++j));
            deal.setOpenPrice(pars.get(i).get(++j));
            deal.setClosePrice(pars.get(i).get(++j));
            deal.setOpenTime(pars.get(i).get(++j));
            deal.setCloseTime(pars.get(i).get(++j));
            deal.setProfit(pars.get(i).get(++j));
            deal.setSwap(pars.get(i).get(++j));
            deal.setCommission(pars.get(i).get(++j));
            deal.setTP(pars.get(i).get(++j));
            deal.setSL(pars.get(i).get(++j));
            deal.setPips(pars.get(i).get(++j));
            deal.setResult(pars.get(i).get(++j));
            deal.setTradeDuration(pars.get(i).get(++j));
            deal.setMagicNumber(pars.get(i).get(++j));
            deal.setOrderComment(pars.get(i).get(++j));
            deal.setMAE(pars.get(i).get(++j));
            deal.setMFE_FX_Blue_Live_account(pars.get(i).get(++j));
            deal.setUserId(user.getId());
            dealService.create(deal);
}
        return "welcome.page";
    }
}
