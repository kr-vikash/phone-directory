package com.directory.main.controller;


import org.springframework.stereotype.Controller;
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

}