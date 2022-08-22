package com.payhere.payhereassignment.service;

import com.payhere.payhereassignment.dto.SimpleResponseDto;
import com.payhere.payhereassignment.dto.TokenDto;
import com.payhere.payhereassignment.dto.UserSignInReq;
import com.payhere.payhereassignment.dto.UserSignUpReq;
import com.payhere.payhereassignment.repository.UserRepository;
import com.payhere.payhereassignment.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManager authenticationManager;

    public SimpleResponseDto signUp(UserSignUpReq userSignUpReq) throws Exception {
        userRepository.findById(userSignUpReq.getEmail());

        userRepository.save(userSignUpReq.toEntity());
        return new SimpleResponseDto(true);
    }

    public ResponseEntity<TokenDto> signIn(UserSignInReq userSignInReq) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            userSignInReq.getEmail(),
                            userSignInReq.getPassword()
                    )
            );
            TokenDto tokenDto = new TokenDto(jwtTokenProvider.generateToken(authentication));
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Authorization", "Bearer " + tokenDto.getAccess_token());

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .headers(httpHeaders)
                    .body(tokenDto);
        } catch (AuthenticationException e) {
            throw new IllegalStateException("권한 없음");
        }
    }
}
