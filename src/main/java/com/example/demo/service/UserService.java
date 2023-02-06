package com.example.demo.service;

import com.example.demo.Repository.UserRepository;
import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public String save(UserDTO userDTO) {
        User user=User.toSaveEntity(userDTO);
        String savedId=userRepository.save(user).getId();
        return savedId;
    }

    public UserDTO login(UserDTO userDTO) {
        Optional<User> optionalUser=userRepository.findByPassword(userDTO.getPassword());
        if(optionalUser.isPresent()) {
            User loginEntity=optionalUser.get();
            if(loginEntity.getPassword().equals(userDTO.getPassword())) {
                return UserDTO.toUserDTO(loginEntity);
            } else {
                return null;
            }
        } else {
            return null;
        }
    }
}
