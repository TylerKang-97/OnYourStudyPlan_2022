package com.oysp.oysp.controller;

import com.oysp.oysp.entity.InfoVO;
import com.oysp.oysp.entity.Subject;
import com.oysp.oysp.entity.User;
import com.oysp.oysp.repository.SubjectRepository;
import com.oysp.oysp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
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
        user.setUserName(infoVO.getUserName());
        user.setUserCollege(infoVO.getUserCollege());
        user.getSubjects().add(subject);

        return userRepository.save(user);
    }

//    @PostMapping(value = "/api/post/test")
//    public InfoVO info(@RequestBody InfoVO infoVO) {
//        System.out.println("===Post InfoVO===" + infoVO.getSubjectName());
//        System.out.println("===Post InfoVO===" + infoVO.getUserName());
//        System.out.println("===Post InfoVO===" + infoVO.getUserCollege());
//        System.out.println("===Post InfoVO===" + infoVO.getCredit());
//        return infoVO;
//    }
}
