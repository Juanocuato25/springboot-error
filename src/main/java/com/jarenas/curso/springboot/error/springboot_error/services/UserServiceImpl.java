package com.jarenas.curso.springboot.error.springboot_error.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jarenas.curso.springboot.error.springboot_error.models.domain.User;

@Service
public class UserServiceImpl implements UserService {

    private List<User> users;

    public UserServiceImpl() {
        this.users = new ArrayList<>();
        users.add(new User(1L, "Camilo", "Arenas"));
        users.add(new User(2L, "Andres", "Guzman"));
        users.add(new User(3L, "Karen", "Silva"));
        users.add(new User(4L, "Alicia", "Parra"));
        users.add(new User(5L, "Jose", "Florez"));
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public User findById(Long id) {
        User user = null;
        for (User u : users) {
            if (u.getId().equals(id)) {
                user = u;
                break;
            }
        }
        return user;
    }

}
