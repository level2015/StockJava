package com.levelup.stock.view;

import com.levelup.spring.service.UserService;
import com.levelup.stock.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

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
        return "welcome.page";
    }
}
