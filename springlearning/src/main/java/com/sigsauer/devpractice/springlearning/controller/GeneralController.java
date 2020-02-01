package com.sigsauer.devpractice.springlearning.controller;

import com.sigsauer.devpractice.springlearning.domain.Message;
import com.sigsauer.devpractice.springlearning.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
     * ??
     *
     * @param model pack of data which sending to view context
     * @return name of mustache page file
     */
    @GetMapping("/")
    public String welcome(Map<String, Object> model) {

        return "welcome";
    }

    /**
     *
     *
     * @param model pack of data which sending to view context
     * @return name of mustache page file
     */
    @GetMapping("/support")
    public String support(Map<String, Object> model) {
        model.put("support", "SIG");
        return "support";
    }


    /**
     *
     *
     *
     * @param model pack of data which sending to view context
     * @return Clients Page
     */
    @GetMapping("/general")
    public String general(Map<String, Object> model) {
        Iterable<Message> messages;
        messages = messageRepository.findAll();

        model.put("messages", messages);

        return "general";
    }

    /**
     *  Send parameters to filter of Clients
     *
     * @param article
     * @param text
     *
     * @param model pack of data which sending to view context
     * @return Clients Page
     */
    @PostMapping("/general")
    public String send(@RequestParam String article, @RequestParam String text, Map<String, Object> model) {
        Message message = new Message( 0L, article, text);
        messageRepository.save(message);

        model.put("message", messageRepository.findAll());
        return "general";

    }

    /**
     *
     *
     * @param filter
     *
     * @param model pack of data which sending to view context
     * @return
     */
    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model) {
        Iterable<Message> messages;
        if(filter != null && !filter.isEmpty()) {
            messages = messageRepository.findByArticle(filter);
        } else {
            messages = messageRepository.findAll();
        }
        model.put("clients", messages);
        return "general";
    }

}
