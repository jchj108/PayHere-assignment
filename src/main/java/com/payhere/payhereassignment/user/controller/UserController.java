package com.payhere.payhereassignment.user.controller;

import com.payhere.payhereassignment.user.domain.User;
import com.payhere.payhereassignment.user.dto.UserDto;
import com.payhere.payhereassignment.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;

    @PostMapping(path = "user")
    public ResponseEntity<UserDto> signUp(@RequestBody User user) {
        return ResponseEntity.ok(new UserDto());
    }
}
