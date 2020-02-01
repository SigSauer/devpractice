package com.sigsauer.devpractice.springlearning.repository;

import com.sigsauer.devpractice.springlearning.domain.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Long> {

    Iterable<Message> findByArticle(String name);
}
