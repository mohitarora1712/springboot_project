package com.lpu.test2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.lpu.test2.entity.AppUser;
import com.lpu.test2.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public AppUser createUser(@RequestBody AppUser user){

        return service.createUser(user);

    }
}