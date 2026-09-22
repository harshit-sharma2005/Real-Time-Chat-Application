package com.harshit.realtimechatapp.controller;

import com.harshit.realtimechatapp.dtos.UserDTO;
import com.harshit.realtimechatapp.model.User;
import com.harshit.realtimechatapp.repository.UserRepository;
import com.harshit.realtimechatapp.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;
    private final AuthenticationService authenticationService;

    @GetMapping("/online")
    public ResponseEntity<List<UserDTO>> getOnlineUsers() {
        List<User> onlineUsers = userRepository.findByIsOnlineTrue();
        List<UserDTO> onlineUserDTOs = onlineUsers.stream()
                .map(authenticationService::convertToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(onlineUserDTOs);
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserDTO> userDTOs = users.stream()
                .map(authenticationService::convertToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(userDTOs);
    }
}
