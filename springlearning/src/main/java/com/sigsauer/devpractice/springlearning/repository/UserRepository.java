package com.sigsauer.devpractice.springlearning.repository;

import com.sigsauer.devpractice.springlearning.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    User findByEmail(String email);
}
