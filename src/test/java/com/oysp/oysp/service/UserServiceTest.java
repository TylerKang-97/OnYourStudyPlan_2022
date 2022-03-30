package com.oysp.oysp.service;

import com.oysp.oysp.entity.User;
import com.oysp.oysp.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Test
    void addSubject() {
    }

    @Test
    @Transactional
    public void checkPassword() {
//        User userInfo = userRepository.findByUserEmail("test1@test.com");
//        System.out.println(userInfo.getPassword());
       boolean check = passwordEncoder.matches("test134", userRepository.findByUserEmail("test1@test.com").getPassword());
       System.out.println(check);
    }

}