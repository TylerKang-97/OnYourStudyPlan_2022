package com.oysp.oysp.service;

import com.oysp.oysp.dto.UserDTO;
import com.oysp.oysp.entity.InfoVO;
import com.oysp.oysp.entity.Subject;
import com.oysp.oysp.entity.User;
import com.oysp.oysp.repository.SubjectRepository;
import com.oysp.oysp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private SubjectRepository subjectRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // DI
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(UserDTO userDTO){
        User user = new User();
        user.setUserEmail(userDTO.getUserEmail());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setUserName(userDTO.getUserName());
        user.setUserCollege(userDTO.getUserCollege());

        userRepository.save(user);
    }

    public boolean checkPassword(String userEmail, String password) {
        String encodedPassword = userRepository.findByUserEmail(userEmail).getPassword();
        String rawPassword = password;

        boolean checkPW = passwordEncoder.matches(rawPassword, encodedPassword);

        if(checkPW == false) {
            System.out.println("===!비밀번호가 정확하지 않습니다.!====");
            return false;
        }
        return true;
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
