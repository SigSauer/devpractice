package com.sigsauer.devpractice.springlearning;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class GreetingController {

    @GetMapping("/hello")
    public String hello(@RequestParam(name = "name", required = false, defaultValue = "anon") String name,
                        Map<String, Object> model) {
        model.put("name", name);
        return "hello";
    }

    @GetMapping("/support")
    public String support(Map<String, Object> model) {
        model.put("support", "SIG");
        return "support";
    }

    @GetMapping("/users")
    public String users( Map<String, Object> model) {
        return "users";
    }
}
