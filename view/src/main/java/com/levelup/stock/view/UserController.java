package com.levelup.stock.view;

import Pars.ParseCSVImpl;
import com.levelup.spring.dao.DealRepository;
import com.levelup.spring.dao.ParseJacksonCSV;
import com.levelup.spring.dao.UserRepository;
import com.levelup.spring.dao.impl.DealOpenCSVImpl;
import com.levelup.spring.service.DealService;
import com.levelup.spring.service.UserService;
import com.levelup.stock.model.Deal;
import com.levelup.stock.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/user")
@SessionAttributes("user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    DealService dealService;


    @RequestMapping(value = "/checkEmail", method = RequestMethod.POST)
    public String checkUser(Model model, @RequestParam String email) {

        User user = new User();
        user.setEmail(email);

        if (userService.checkUserByEmail(user)) {

            return "messageRegister.page";
        }
        return "null.page";
    }


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createUser(Model model, @ModelAttribute("user") User user,
                             @RequestParam String email,
                             @RequestParam String password,
                             @RequestParam String name) {
        user.setEmail(email);
        user.setPassword(password);
        user.setName(name);
        if (userService.checkUserByEmail(user)) {

            return "messageRegister.page";

        } else {
            userService.create(user);

//            ParseJacksonCSV parseJacksonCSV = new DealOpenCSVImpl();
//            List<Deal> deals = parseJacksonCSV.parse("c://orders-example.csv");
//            for (Deal deal : deals) {
//                deal.setUserId(user.getId());
//                dealService.create(deal);
//            }


//            ParseCSVImpl myParse = new ParseCSVImpl();
//            ArrayList<ArrayList<String>> pars = myParse.parseCSV("c://orders-example.csv");
//            for (int i = 0; i < pars.size(); i++) {
//                Deal deal = new Deal();
//                int j = -1;
//                deal.setType(pars.get(i).get(++j));
//                deal.setTicket(pars.get(i).get(++j));
//                deal.setSymbol(pars.get(i).get(++j));
//                deal.setLots(Double.parseDouble(pars.get(i).get(++j)));
//                deal.setBuySell(pars.get(i).get(++j));
//                deal.setOpenPrice(Double.parseDouble(pars.get(i).get(++j)));
//                deal.setClosePrice(Double.parseDouble(pars.get(i).get(++j)));
//
//                DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//                Date date = new Date();
//                try {
//                     date = format.parse(pars.get(i).get(++j));
//                } catch (ParseException e) {
//                    e.printStackTrace();
//                }
//                try {
//                    date = format.parse(pars.get(i).get(++j));
//                } catch (ParseException e) {
//                    e.printStackTrace();
//                }
//                deal.setOpenTime(date);
//                deal.setCloseTime(date);
//                deal.setProfit(Double.parseDouble(pars.get(i).get(++j)));
//                deal.setSwap(Double.parseDouble(pars.get(i).get(++j)));
//                deal.setCommission(pars.get(i).get(++j));
//                deal.setTp(Double.parseDouble(pars.get(i).get(++j)));
//                deal.setSl(Double.parseDouble(pars.get(i).get(++j)));
//                deal.setPips(Double.parseDouble(pars.get(i).get(++j)));
//                deal.setResult(pars.get(i).get(++j));
//                deal.setTradeDuration(Double.parseDouble(pars.get(i).get(++j)));
//                deal.setMagicNumber(pars.get(i).get(++j));
//                deal.setOrderComment(pars.get(i).get(++j));
//                deal.setMae(Double.parseDouble(pars.get(i).get(++j)));
//                deal.setfXBlueLiveAccount(pars.get(i).get(++j));
//                deal.setUserId(user.getId());
//                dealService.create(deal);
//            }

            return "null.page";
        }
    }

    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    public String signInUser(Model model, @ModelAttribute("user") User user,
                             @RequestParam String email,
                             @RequestParam String password) {

        User user2 = userService.getUserByEmailAndPassword(email, password);
        if (user2 != null) {
            user.setUser(user2);
            return "null.page";
        } else {
            return "messageLogin.page";
        }
    }
}
