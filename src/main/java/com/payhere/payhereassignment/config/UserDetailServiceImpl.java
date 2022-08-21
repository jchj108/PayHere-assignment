package com.payhere.payhereassignment.config;

import com.payhere.payhereassignment.domain.User;
import com.payhere.payhereassignment.exception.UserNotFoundException;
import com.payhere.payhereassignment.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) {
        System.out.println("email in loadUserByUsername = " + email);
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
