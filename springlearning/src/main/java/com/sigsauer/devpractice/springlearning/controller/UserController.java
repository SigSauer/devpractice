package com.sigsauer.devpractice.springlearning.controller;

import com.sigsauer.devpractice.springlearning.domain.Role;
import com.sigsauer.devpractice.springlearning.domain.User;
import com.sigsauer.devpractice.springlearning.repository.UserRepository;
import com.sun.mail.imap.protocol.UIDSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.BeanDefinitionDsl;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/users")
@PreAuthorize("hasAuthority('ADMIN')")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public String userList(@RequestParam(required = false, defaultValue = "") Long id,
                           @RequestParam(required = false, defaultValue = "") String username, Model model) {
        List<User> userList;
        if(id != null && !userRepository.getById(id).isEmpty()) {
            return "redirect:/users/"+id;
        } else {
            userList = (username != null && !username.isEmpty()) ?
                    userRepository.findAllByUsernameContains(username) : userRepository.findAll();
        }
        if(userList.size() == 1) {
            return "redirect:/users/"+userList.get(0).getId();
        }

        model.addAttribute("users",userList);

        return "userList";
    }

    @GetMapping("{user}")
    public String userEditForm(@PathVariable User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());
        return "userEdit";
    }

    @PostMapping
    public String userSave(@RequestParam("userId") User user,
                           @RequestParam String username,
                           @RequestParam Map<String, String> form //list of roles, which come from edit page
                            ) {
        user.setUsername(username);

        Set<String> roles = Arrays.stream(Role.values()). //get list of all roles
                map(Role::name). //and map it on name
                collect(Collectors.toSet()); //collect to Set

        user.getRoles().clear();

        for (String key : form.keySet()) {
            if(roles.contains(key)) {
                user.getRoles().add(Role.valueOf(key));
                }
            }
        userRepository.save(user);

        return "redirect:/users";
    }
}
