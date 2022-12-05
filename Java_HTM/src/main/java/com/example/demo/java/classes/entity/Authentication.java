package com.example.demo.java.classes.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "authentication")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Authentication {

    @Id
    @Column(name = "ID_")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    BigInteger id;

    @Column(name = "username_")
    String username;

    @Column(name = "password_")
    String password;

    public Authentication(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
