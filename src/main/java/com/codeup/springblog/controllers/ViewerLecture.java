package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ViewerLecture {
    @GetMapping("/users/{role}")
    public String showUsers(@PathVariable String role, Model viewModel){
        List<String> users = new ArrayList<>();
        users.add("James");
        users.add("Kevin");
        users.add("Alexa");
        users.add("Young");

        viewModel.addAttribute("users", users);
        viewModel.addAttribute("role", role);

        return "users";
    }
}
