package com.levelup.stock.view;

import Pars.ParseCSVImpl;
import com.levelup.spring.dao.ParseJacksonCSV;
import com.levelup.spring.dao.UserRepository;
import com.levelup.spring.dao.impl.DealJacksonCSVImpl;
import com.levelup.spring.dao.impl.DealOpenCSVImpl;
import com.levelup.spring.service.DealService;
import com.levelup.spring.service.UserService;
import com.levelup.stock.model.Deal;
import com.levelup.stock.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
@SessionAttributes("user")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    DealService dealService;


    @RequestMapping(value = "/checkEmail", method = RequestMethod.POST)
    public String createUser(Model model, @RequestParam String email) {

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
        //User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setName(name);
        if (userService.checkUserByEmail(user)) {
            return "messageRegister.page";
        }else{
            userService.create(user);
            return "null.page";}
//        ParseCSVImpl myParse = new ParseCSVImpl();
//        ArrayList<ArrayList<String>> pars = myParse.parseCSV("f://orders-example.csv");
        //  ParseJacksonCSV parseJacksonCSV = new DealOpenCSVImpl();

//        List<Deal> deals = parseJacksonCSV.parse("f://orders-example.csv");
//        for (Deal deal : deals) {
//            //System.out.println(deal.getOpenTime() + " " + deal.getCloseTime());
//             deal.setUserId(user.getId());
//             dealService.create(deal);
//        }
//        for(int i=0; i<pars.size();i++){
//            Deal deal = new Deal();
//            int j=-1;
//            deal.setType(pars.get(i).get(++j));
//            deal.setTicket(pars.get(i).get(++j));
//            deal.setSymbol(pars.get(i).get(++j));
//            deal.setLots(pars.get(i).get(++j));
//            deal.setBuySell(pars.get(i).get(++j));
//            deal.setOpenPrice(pars.get(i).get(++j));
//            deal.setClosePrice(pars.get(i).get(++j));
//            deal.setOpenTime(pars.get(i).get(++j));
//            deal.setCloseTime(pars.get(i).get(++j));
//            deal.setProfit(pars.get(i).get(++j));
//            deal.setSwap(pars.get(i).get(++j));
//            deal.setCommission(pars.get(i).get(++j));
//            deal.setTP(pars.get(i).get(++j));
//            deal.setSL(pars.get(i).get(++j));
//            deal.setPips(pars.get(i).get(++j));
//            deal.setResult(pars.get(i).get(++j));
//            deal.setTradeDuration(pars.get(i).get(++j));
//            deal.setMagicNumber(pars.get(i).get(++j));
//            deal.setOrderComment(pars.get(i).get(++j));
//            deal.setMAE(pars.get(i).get(++j));
//            deal.setMFE_FX_Blue_Live_account(pars.get(i).get(++j));
//            deal.setUserId(user.getId());
//            dealService.create(deal);
//}

    }

    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    public String signInUser(Model model, @ModelAttribute("user") User user,
                             @RequestParam String email,
                             @RequestParam String password) {
        // User user = new User();
        System.out.println(user.getEmail());
        if (user.getEmail()==null || user.getPassword()==null) {
            user.setEmail(email);
            user.setPassword(password);
            user.setName("ddd");
        }
        // user2 = (User)userRepository.getUserByEmail(email);
        //    System.out.println(user.getEmail());

// if(userService.getUserByEmail(email).isEmpty()){
//        System.out.println("1");}else{
//     System.out.println(userService.getUserByEmail(email).get(0).toString());
// }
        if (userService.checkUserByEmailAndPassword(user)) {

            return "main.page";
        } else {
            return "messageLogin.page";
        }
    }
}
