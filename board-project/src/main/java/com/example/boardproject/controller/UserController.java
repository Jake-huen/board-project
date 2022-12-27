package com.example.boardproject.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/user")
@Controller
public class UserController {
    @GetMapping
    public String user(ModelMap map) {
        map.addAttribute("users", List.of());
        return "user/index";
    }
}
