package com.oysp.oysp.repository;

import com.oysp.oysp.entity.Subject;
import com.oysp.oysp.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SubjectRepositoryTest {

    @Autowired
    SubjectRepository subjectRepository;

    @Autowired
    UserRepository userRepository;

    @Test
    public void AddSub() {
        User user = userRepository.findById(19L).get();
        Subject subject = new Subject();
        subject.setSubjectName("circuit");
        subject.setCredit(3);

       // user.setSubjects(subject);

        subjectRepository.save(subject);
    }

}