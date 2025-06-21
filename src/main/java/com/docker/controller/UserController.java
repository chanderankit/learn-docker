package com.docker.controller;

import com.docker.entity.UserEntity;
import com.docker.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserEntity>> getUsers() {
        List<UserEntity> list = userService.getAllUsers();
        return ResponseEntity.ok(list);
    }

    @PostMapping
    public ResponseEntity<UserEntity> saveUser(@RequestBody UserEntity request) {
        UserEntity user = userService.saveUser(request);
        return ResponseEntity.ok(user);
    }

}
