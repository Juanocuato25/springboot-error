package com.jarenas.curso.springboot.error.springboot_error;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jarenas.curso.springboot.error.springboot_error.models.domain.User;

@Configuration
public class AppConfig {


    @Bean
    public List<User> Users() {
        List<User> users = new ArrayList<>();
        users.add(new User(1L, "Camilo", "Arenas"));
        users.add(new User(2L, "Andres", "Guzman"));
        users.add(new User(3L, "Karen", "Silva"));
        users.add(new User(4L, "Alicia", "Parra"));
        users.add(new User(5L, "Jose", "Florez"));
        return users;
    }
}
