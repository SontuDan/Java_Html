package com.example.demo.java.classes.controller;


import com.example.demo.java.classes.dto.HumanDTO;
import com.example.demo.java.classes.repository.AuthenticationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

//@Controller
@RestController
@RequiredArgsConstructor
public class TestController {
    private final AuthenticationRepository authenticationRepository;
/*
    @GetMapping("/test")
    @ResponseBody
    public String test(@RequestParam("login") String userName, @RequestParam("password") String passWord,
                       @ModelAttribute Authentication humanDTO, Model model) throws SQLException {

        humanDTO.setUsername(userName);
        humanDTO.setPassword(passWord);

        for (Authentication authentication : authenticationRepository.findAll()) {

            System.out.println(humanDTO.getUsername() + " " + humanDTO.getPassword());

            if (authentication.getUsername().equals(humanDTO.getUsername())) {
                model.addAttribute("error", "wrong credentials");
                return "User already exits ! ";
            }
        }

        authenticationRepository.save(new Authentication(humanDTO.getUsername(), humanDTO.getPassword()));
        return "User successfully added !\nUsername [ " + userName + " ] \nPassword [ " + passWord + " ]";
    }*/

//    la tine in afara de autentificare in DTO va fi un oarecare task si automat se va pune ziua de astazi.
//    Adica va fi obiectul Task cu descrierea si timpul crearii.

    @PostMapping("/user")
    public String registerUserCredential(@RequestBody HumanDTO user, String Return) {
        System.out.println("User ID: " + user.getUsername());
        System.out.println("Password: " + user.getPassword());


        System.out.println("Full name: " + user.getFirstname() + " " + user.getLastname());
        Return ="Username: " + user.getUsername() + "\nPassword: " + user.getPassword() + "\nFull name: " +
                user.getFirstname() + " " + user.getLastname();
        return Return;
    }
}