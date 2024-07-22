package com.example.madcamp4_backend.madcamp4_backend.repository;

import com.example.madcamp4_backend.madcamp4_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByName(String name);
}
