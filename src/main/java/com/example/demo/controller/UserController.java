package com.example.demo.controller;

import com.example.demo.dto.UserDTO;
import com.example.demo.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/join.html")
    public String joinForm(){return "join";}

    @PostMapping("user/join")
    public String save(@ModelAttribute() UserDTO userDTO) {
        userService.save(userDTO);
        return "index";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute UserDTO userDTO, HttpSession session) {
        UserDTO loginResult=userService.login(userDTO);
        if(loginResult != null) {
            session.setAttribute("loginPassword",loginResult.getPassword());
            session.setAttribute("id",loginResult.getId());
            return "main";
        } else {
            return "index";
        }
    }
}
