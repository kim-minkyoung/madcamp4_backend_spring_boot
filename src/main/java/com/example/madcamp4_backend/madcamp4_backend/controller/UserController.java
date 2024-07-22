package com.example.madcamp4_backend.madcamp4_backend.controller;

import com.example.madcamp4_backend.madcamp4_backend.model.User;
import com.example.madcamp4_backend.madcamp4_backend.service.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers(@RequestParam(required = false) String name) {
        if (name != null) {
            return userService.findByName(name);
        }
        return userService.findAll();
    }
}
