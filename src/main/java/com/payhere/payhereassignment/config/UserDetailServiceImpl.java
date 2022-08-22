package com.payhere.payhereassignment.config;

import com.payhere.payhereassignment.user.domain.User;
import com.payhere.payhereassignment.user.exception.UserNotFoundException;
import com.payhere.payhereassignment.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) {
        Optional<User> user = userRepository.findById(email);
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        try {
            return new org
                    .springframework
                    .security
                    .core
                    .userdetails
                    .User(user.orElseThrow(UserNotFoundException::new).getEmail(), user.orElseThrow(UserNotFoundException::new).getPassword(), grantedAuthorities);
        } catch (UserNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
