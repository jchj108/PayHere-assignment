package com.payhere.payhereassignment.user.controller;

import com.payhere.payhereassignment.common.dto.SimpleResponseDto;
import com.payhere.payhereassignment.security.JwtTokenProvider;
import com.payhere.payhereassignment.user.dto.TokenDto;
import com.payhere.payhereassignment.user.dto.UserSignInReq;
import com.payhere.payhereassignment.user.dto.UserSignUpReq;
import com.payhere.payhereassignment.user.exception.UserNotFoundException;
import com.payhere.payhereassignment.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@Slf4j
public class UserController {
    private final UserService userService;

    private final JwtTokenProvider jwtTokenProvider;

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> userNotFoundExceptionHandler(UserNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }
    @PostMapping(path = "/signUp")
    public ResponseEntity<SimpleResponseDto> signUp(@Validated UserSignUpReq userSignUpReq) throws Exception {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userService.signUp(userSignUpReq));
    }

    @PostMapping(path = "/signIn")
    public ResponseEntity<TokenDto> signIn(@Validated UserSignInReq userSignInReq, HttpServletResponse response) throws Exception {
        ResponseEntity<TokenDto> responseEntity = userService.signIn(userSignInReq);
        // ????????? ??? ?????? ??????
        Cookie cookie = new Cookie(
                "access_token",
                responseEntity.getBody().getAccess_token()
        );
        cookie.setPath("/");
        response.addCookie(cookie);
        return responseEntity;
    }
}
