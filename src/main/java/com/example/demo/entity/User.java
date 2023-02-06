package com.example.demo.entity;

import com.example.demo.dto.UserDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 45, nullable = false)
    private String id;

    @Column(length = 45, nullable = false)
    private String password;
    @Column(length = 45, nullable = false)
    private String name;
    @Column(length = 45, nullable = false)
    private String phone;
    @Column(length = 45, nullable = false)
    private String email;

    public User() {
    }

    @Builder
    public User(String password, String name, String phone, String email) {
        this.password=password;
        this.name=name;
        this.phone=phone;
        this.email=email;
    }

    public static User toSaveEntity(UserDTO userDTO) {
        User user=new User();
        user.setPassword(userDTO.getPassword());
        user.setName(userDTO.getName());
        user.setPhone(userDTO.getPhone());
        user.setEmail(userDTO.getEmail());
        return user;
    }
}
