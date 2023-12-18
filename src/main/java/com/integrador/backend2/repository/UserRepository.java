package com.integrador.backend2.repository;

import com.integrador.backend2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface  UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findUserByEmailAndPassword(String email, String password);

    User findByEmail(String email);
}
