package com.payhere.payhereassignment.user.service;

import com.payhere.payhereassignment.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {
    public User signUp(User user) {
        return null;
    }
}
