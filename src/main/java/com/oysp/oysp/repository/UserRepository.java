package com.oysp.oysp.repository;

import com.oysp.oysp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
     // findBy 단건의 경우 타입지정 가능 여러건일 경우 컬레션 사용
     User findByUserEmail(String email);

}
