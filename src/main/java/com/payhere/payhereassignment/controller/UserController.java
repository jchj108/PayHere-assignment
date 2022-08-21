package com.payhere.payhereassignment.controller;

import com.payhere.payhereassignment.dto.SimpleResponseDto;
import com.payhere.payhereassignment.dto.TokenDto;
import com.payhere.payhereassignment.dto.UserSignInReq;
import com.payhere.payhereassignment.dto.UserSignUpReq;
import com.payhere.payhereassignment.security.JwtTokenProvider;
import com.payhere.payhereassignment.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@Slf4j
public class UserController {
    private final UserService userService;

    private final JwtTokenProvider jwtTokenProvider;

    @PostMapping(path = "user/signUp")
    public ResponseEntity<SimpleResponseDto> signUp(@Validated UserSignUpReq userSignUpReq) throws Exception {
        return ResponseEntity.ok().body(userService.signUp(userSignUpReq));
    }

    @PostMapping(path = "user/signIn")
    public ResponseEntity<TokenDto> signIn(@Validated UserSignInReq userSignInReq) throws Exception {
        return userService.signIn(userSignInReq);
    }
}
