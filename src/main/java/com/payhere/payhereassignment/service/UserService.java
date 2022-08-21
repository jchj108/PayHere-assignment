package com.payhere.payhereassignment.service;

import com.payhere.payhereassignment.domain.User;
import com.payhere.payhereassignment.dto.SimpleResponseDto;
import com.payhere.payhereassignment.dto.UserSignUpReq;
import com.payhere.payhereassignment.repository.UserRepository;
import com.payhere.payhereassignment.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManager authenticationManager;

    public SimpleResponseDto signUp(UserSignUpReq userSignUpReq) throws Exception {
        User user = userRepository.findById(userSignUpReq.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("이메일 중복"));

        return new SimpleResponseDto(true);
    }
}
