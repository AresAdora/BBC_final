package com.example.demo.dto;

import com.example.demo.entity.User;
import lombok.Data;

@Data
public class UserDTO {
    private String id;
    private String password;
    private String name;
    private String phone;
    private String email;

    public static UserDTO toUserDTO(User user) {
        UserDTO userDTO=new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setPassword(user.getPassword());
        userDTO.setName(user.getName());
        userDTO.setPhone(user.getPhone());
        userDTO.setEmail(user.getEmail());
        return userDTO;
    }
}
