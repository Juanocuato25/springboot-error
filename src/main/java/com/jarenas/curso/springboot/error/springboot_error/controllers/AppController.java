package com.jarenas.curso.springboot.error.springboot_error.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jarenas.curso.springboot.error.springboot_error.models.domain.User;
import com.jarenas.curso.springboot.error.springboot_error.services.UserService;


@RestController
@RequestMapping("/app")
public class AppController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String index(){
        //int value = 100/0;
        int value = Integer.parseInt("Hola");
        System.out.println(value);
        return "Ok 200";
    }

    @GetMapping("/show/{id}")
    public User showById(@PathVariable Long id){
        User user = userService.findById(id);
        System.out.println(user.getName());
        return  user;
    }

}
