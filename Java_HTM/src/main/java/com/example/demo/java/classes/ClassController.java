package com.example.demo.java.classes;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.SQLException;

@Controller
public class ClassController {
    HumanDTO humanVar;

    @GetMapping()
    public String greetingForm(Model model) {
        model.addAttribute("userName", humanVar);
        return "index";
    }

    @PostMapping("/index")
    public String greetingSubmit(@ModelAttribute HumanDTO greeting) throws SQLException {
        HumanDTO var = new HumanDTO();
        humanVar = greeting;
        // add to database
        SQLQuery run = new SQLQuery();
        System.out.println(humanVar.userName + "  -------------  " + humanVar.userName);
        run.inserDataDB(humanVar);
        return "redirect:result";
    }

    @GetMapping("/result")
    public String showResult(Model model) {
        model.addAttribute("human", humanVar.userName);
        model.addAttribute("humanemail", humanVar.userEmail);
        return "result";
    }
}