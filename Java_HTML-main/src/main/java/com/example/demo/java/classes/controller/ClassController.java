package com.example.demo.java.classes.controller;

import com.example.demo.java.classes.entity.Authentication;
import com.example.demo.java.classes.repository.AuthenticationRepository;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@Controller
@RequiredArgsConstructor
public class ClassController {

    private final AuthenticationRepository authenticationRepository;


    @GetMapping()
    public String greetingForm() {
        return "index";
    }

    @PostMapping("/index")
    public String greetingSubmit(@ModelAttribute Authentication humanDTO, Model model) throws SQLException {

        for (Authentication authentication : authenticationRepository.findAll()) {

            System.out.println(humanDTO.getUsername() + " " + humanDTO.getPassword());

            if (authentication.getUsername().equals(humanDTO.getUsername())) {
                model.addAttribute("error", "wrong credentials");
                return "index";
            }
        }

        authenticationRepository.save(new Authentication(humanDTO.getUsername(), humanDTO.getPassword()));
        return "redirect:result";
    }

    @GetMapping("/result")
    public String showResult(Model model) {
        model.addAttribute("humans", authenticationRepository.findAll());
        return "result";
    }
}