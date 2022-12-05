package com.example.demo.java.classes.Request;

import com.example.demo.java.classes.dto.HumanDTO;
import com.example.demo.java.classes.dto.UserDTO;
import lombok.Getter;
import lombok.Setter;


public class RequestDTO {
    @Getter
    UserDTO user = new UserDTO();

    public String getUser() {
        return user.getFirstname()+" "+user.getLastname();
    }

    @Getter
    @Setter
    HumanDTO auth = new HumanDTO();
}
