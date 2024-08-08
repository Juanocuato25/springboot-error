package com.jarenas.curso.springboot.error.springboot_error.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jarenas.curso.springboot.error.springboot_error.exceptions.UserNotFoundException;
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

    // @GetMapping("/show/{id}")
    // public ResponseEntity<?> showById(@PathVariable Long id){
    //     Optional<User> optionalUser = userService.findById(id);
    //     if (optionalUser.isEmpty()) {
    //         return ResponseEntity.notFound().build();
    //     }
    //     return ResponseEntity.ok(optionalUser.orElseThrow());
    // }
    
    @GetMapping("/show/{id}")
    public User showByIdU(@PathVariable Long id){
        User user = userService.findById(id).orElseThrow(()-> new UserNotFoundException("Error, user not found"));
        // System.out.println(user.getName());
        return  user;
    }

}
