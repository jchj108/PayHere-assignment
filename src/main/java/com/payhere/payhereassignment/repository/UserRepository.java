package com.payhere.payhereassignment.repository;

import com.payhere.payhereassignment.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {

}
