package com.test.project.controller;

import com.test.project.model.User;
import com.test.project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class BaseController {

    @Value("${project.text}")
    private String text;

    @Autowired
    UserService userService;

    // todo: default method

    @GetMapping(value = "users")
    public ModelAndView getUsers() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("users");
        modelAndView.getModel().put("greeting", text);

        User user = new User();
        user.setEmail("test@test.com");
        user.setName("Iurii");

        userService.addUser(user);

        modelAndView.getModel().put("users", userService.listUsers());

        return modelAndView;
    }

    // @PathVariable
    // @Autowired and Scopes -> service
    // @RequestParam
    // RequestMethods
    // SimpleMappingExceptionResolver
    // Aspects -> logging
    // @PostConstruct
}
