package com.oysp.oysp.repository;

import com.oysp.oysp.entity.Subject;
import com.oysp.oysp.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @Autowired
    SubjectRepository subjectRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    @Transactional
    public void AddSubject() {
        User user = userRepository.findById(48L).get();
        Subject subject = new Subject();

        subject.setSubjectName("CProgramming");
        subject.setCredit(3);
        //subject.setUser(user);
        subjectRepository.save(subject);
        user.addSubject(subject);
    // subject를 받아와서 리포지토리에 저장 후 user entity에 addsubject 메서드를 사용한다.
        // 이때 subject는 정상적으로 코드를 부여받아 유효한 객체로 저장됨.
    }

    @Test
    @Transactional
    public void CreateUser() {
        User user = new User();
        user.setUserName("tyler");
        user.setUserCollege("mjc");
        user.setUserEmail("kingksy777@gmail.com");
        user.setPassword(passwordEncoder.encode("kang0811"));

        System.out.println(user);
        userRepository.save(user);
    }

    @Test
    @Transactional
    public void findUser() {
        User userInfo = userRepository.findByUserEmail("kingksy777@naver.com");
       System.out.println(userInfo.getPassword());
    }
}