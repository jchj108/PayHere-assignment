package com.payhere.payhereassignment.user.service;

import com.payhere.payhereassignment.user.domain.User;
import com.payhere.payhereassignment.common.dto.SimpleResponseDto;
import com.payhere.payhereassignment.user.dto.TokenDto;
import com.payhere.payhereassignment.user.dto.UserSignInReq;
import com.payhere.payhereassignment.user.dto.UserSignUpReq;
import com.payhere.payhereassignment.user.repository.UserRepository;
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
        userRepository.findById(userSignUpReq.getId())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });;
        User user = userSignUpReq.toEntity();
        user.hashPassword(passwordEncoder);
        userRepository.save(user);
        return new SimpleResponseDto(true);
    }

    public ResponseEntity<TokenDto> signIn(UserSignInReq userSignInReq) {
        try {
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userSignInReq.getId(), userSignInReq.getPassword());
            /*
                DB의 UserDetail과 토큰의 정보를 비교해 인증을 실행한다.
                이때 토큰의 RawPassword를 encoding 하므로 암호화가 되지 않았거나 인코딩 방식이 맞지 않으면 인증에 실패할 수 있다.
             */
            Authentication authentication = authenticationManager.authenticate(token);
            TokenDto tokenDto = new TokenDto(jwtTokenProvider.generateToken(authentication));
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Authorization", "Bearer " + tokenDto.getAccess_token());

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .headers(httpHeaders)
                    .body(tokenDto);
        } catch (AuthenticationException e) {
            throw new IllegalStateException("로그인에 실패했습니다. 아이디 비밀번호를 확인하세요");
        }
    }
}
