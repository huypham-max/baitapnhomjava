package com.healthcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthcare.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
    // Tìm người dùng theo username
    User findByUsername(String username);
}
