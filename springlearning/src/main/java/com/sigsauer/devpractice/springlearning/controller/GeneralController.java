package com.sigsauer.devpractice.springlearning.controller;

import com.sigsauer.devpractice.springlearning.domain.Message;
import com.sigsauer.devpractice.springlearning.domain.User;
import com.sigsauer.devpractice.springlearning.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 *
 *
 *  @author @SigSauer
 *  @version 1.0
 */

@Controller
public class GeneralController {

    @Autowired
    private MessageRepository messageRepository;

    /**
     * Welcome page
     *
     * @param model pack of data which sending to view context
     * @return name of mustache page file
     */
    @GetMapping("/")
    public String welcome(Map<String, Object> model) {

        return "welcome";
    }

//    /**
//     * Support page
//     *
//     * @param model pack of data which sending to view context
//     * @return name of mustache page file
//     */
//    @GetMapping("/support")
//    public String support(Map<String, Object> model) {
//        model.put("support", "SIG");
//        return "support";
//    }


    /**
     *  General page
     *
     * @param model pack of data which sending to view context
     * @return page
     */
    @GetMapping("/general")
        public String general(@RequestParam(required = false) String filter, Model model) {
        Iterable<Message> messages;
        if(filter != null && !filter.isEmpty()) {
            messages = messageRepository.findByArticle(filter);
        } else {
            messages = messageRepository.findAll();
        }

        model.addAttribute("messages", messages);
        model.addAttribute("filter", filter);

        return "general";
    }

    /**
     * Add messages on General page
     *
     * @param user
     * @param article
     * @param text
     *
     * @param model pack of data which sending to view context
     * @return
     */
    @PostMapping("/general")
    public String send(@AuthenticationPrincipal User user,
                           @RequestParam String article, @RequestParam String text, Map<String, Object> model) {
        Message message = new Message(user, article, text);
        messageRepository.save(message);
        model.put("message", messageRepository.findAll());
        return "redirect:/general";

    }
}
