package com.oysp.oysp.controller;

import com.oysp.oysp.dto.LoginDTO;
import com.oysp.oysp.dto.UserDTO;
import com.oysp.oysp.entity.InfoVO;
import com.oysp.oysp.entity.Subject;
import com.oysp.oysp.entity.User;
import com.oysp.oysp.entity.UserVO;
import com.oysp.oysp.repository.SubjectRepository;
import com.oysp.oysp.repository.UserRepository;
import com.oysp.oysp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class Controller {

    private final UserRepository userRepository;
    private final SubjectRepository subjectRepository;
    private final UserService userService;


    @Autowired
    private PasswordEncoder passwordEncoder;


    @GetMapping("/api")
    public String hello() {
        return "Hello Tyler!";
    }

    @GetMapping("/api/user")
    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    @GetMapping("api/subject")
    public List<Subject> findAllSubject() {
        return subjectRepository.findAll();
    }

    @PostMapping(value = "/api/post/test")
    public User info(@RequestBody InfoVO infoVO) {

        System.out.println("Post Test" + infoVO);

        Subject subject = new Subject();
        subject.setSubjectName(infoVO.getSubjectName());
        subject.setCredit(infoVO.getCredit());
        subjectRepository.save(subject);

        //System.out.println("===post_Sub===" + subject);

        User user = new User();
//        user.setUserName(infoVO.getUserName());
//        user.setUserCollege(infoVO.getUserCollege());

        user.getSubjects().add(subject);

        return userRepository.save(user);
    }

    @PostMapping(value = "api/post/serviceTest")
    public String setting(@RequestBody InfoVO infoVO) {
        User user = userRepository.findById(48L).get();
        Subject subject = new Subject();
        subject.setSubjectName(infoVO.getSubjectName());
        subject.setCredit(infoVO.getCredit());
        System.out.print("infoVO" + infoVO.getSubjectName());

        subjectRepository.save(subject);

        user.addSubject(subject);
        userRepository.save(user);
        return "api/user";
    }

    @PostMapping(value = "api/post/signup")
    public String signUp(@RequestBody UserDTO userDTO) {
        userService.createUser(userDTO);
        return "api/user";
    }

    @PostMapping(value = "api/post/login")
    public String login(@RequestBody LoginDTO loginDTO) {
        userService.checkPassword(loginDTO.getUserEmail(), loginDTO.getPassword());
        if(userService.checkPassword(loginDTO.getUserEmail(), loginDTO.getPassword()) == true) {
            return "login success!";
        } else {
            return "login false..";
        }

    }
}


