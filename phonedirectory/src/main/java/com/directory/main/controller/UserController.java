package com.directory.main.controller;


import com.directory.main.modal.User;
import com.directory.main.modal.UserDto;
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
        return user;
    }

    @GetMapping("/user")
    public UserDto getPrincipal(@AuthenticationPrincipal Principal principal){
        return phoneService.getUserInfo(principal);
    }

    @GetMapping("/user/{id}")
    public UserDto getPrincipal(@RequestParam Long id){
        return phoneService.getUser(id);
    }

}
