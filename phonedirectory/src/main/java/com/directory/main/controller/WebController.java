package com.directory.main.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 */

@Controller
public class WebController {

    @RequestMapping("/detail")
    public String webInterface() {
        return "index";
    }

    @RequestMapping("")
    public String webInter() {
        return "index";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/logout")
    public String logout(){
        return "logout";
    }

    @RequestMapping("/logout-success")
    public String logoutSuccess(){
        return "logout";
    }

}