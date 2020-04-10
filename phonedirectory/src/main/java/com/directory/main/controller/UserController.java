package com.directory.main.controller;


import com.directory.main.modal.User;
import com.directory.main.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping
public class UserController {

    @Autowired
    private PhoneService phoneService;

    @PostMapping("/api/signup")
    public User createUser(@RequestBody User user){
        phoneService.saveProfile(user);
        System.out.println(user.getUsername());
        return user;
    }

    @GetMapping("/user")
    public Principal getPrincipal(@AuthenticationPrincipal Principal principal){
        return principal;
    }

}
