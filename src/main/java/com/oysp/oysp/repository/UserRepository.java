package com.oysp.oysp.repository;

import com.oysp.oysp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
