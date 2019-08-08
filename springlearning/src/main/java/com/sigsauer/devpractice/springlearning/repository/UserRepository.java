package com.sigsauer.devpractice.springlearning.repository;

import com.sigsauer.devpractice.springlearning.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
