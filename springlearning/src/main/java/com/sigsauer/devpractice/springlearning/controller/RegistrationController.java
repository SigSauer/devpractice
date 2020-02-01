package com.sigsauer.devpractice.springlearning.controller;

import com.sigsauer.devpractice.springlearning.domain.Role;
import com.sigsauer.devpractice.springlearning.domain.User;
import com.sigsauer.devpractice.springlearning.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/registration")
    public String registration() {

        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User receivedUser, Map<String, Object> model) {
        if(userRepository.findByEmail(receivedUser.getEmail()) != null) {
            model.put("message", "This email already registered! You can restore account");
            return "registration";
        } else if(userRepository.findByUsername(receivedUser.getUsername()) != null) {
            model.put("message", "This username already use! Choose another username");
        } else {
            receivedUser.setActive(true);
            receivedUser.setRoles(Collections.singleton(Role.CONFIRMED));
            userRepository.save(receivedUser);
        }
        return "redirect:/login";
    }

    private void sendConfirmation() {}





}
