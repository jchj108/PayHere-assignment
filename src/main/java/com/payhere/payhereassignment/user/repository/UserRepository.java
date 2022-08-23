package com.payhere.payhereassignment.user.repository;

import com.payhere.payhereassignment.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
