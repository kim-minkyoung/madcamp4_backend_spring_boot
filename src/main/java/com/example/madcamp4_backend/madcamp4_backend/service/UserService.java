package com.example.madcamp4_backend.madcamp4_backend.service;

import com.example.madcamp4_backend.madcamp4_backend.model.User;
import com.example.madcamp4_backend.madcamp4_backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public List<User> findByName(String name) {
        return userRepository.findByName(name);
    }
}
