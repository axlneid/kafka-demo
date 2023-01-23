package com.axl.demo.kafka.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserActionController {

    @GetMapping(value = {"/", "/index"})
    public String index(Model model) {
        model.addAttribute("title", "title");
        return "index";
    }
}
