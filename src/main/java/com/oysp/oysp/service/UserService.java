package com.oysp.oysp.service;

import com.oysp.oysp.entity.InfoVO;
import com.oysp.oysp.entity.Subject;
import com.oysp.oysp.entity.User;
import com.oysp.oysp.repository.SubjectRepository;
import com.oysp.oysp.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private SubjectRepository subjectRepository;

    // DI
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addSubject(InfoVO infoVO) {
        User user = userRepository.findById(19L).get();
        Subject subject = new Subject();
        subject.setSubjectName(infoVO.getSubjectName());
        subject.setCredit(infoVO.getCredit());
        System.out.print("infoVO" + infoVO.getSubjectName());

        subjectRepository.save(subject);

        user.addSubject(subject);
        userRepository.save(user);
    }
}
