package com.sigsauer.devpractice.springlearning.repository;

import com.sigsauer.devpractice.springlearning.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);


    List<User> getById(Long id);

    List<User> findAllByUsernameContains(String username);

}
