package com.payhere.payhereassignment.repository;

import com.payhere.payhereassignment.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
