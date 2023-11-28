package com.integrador.backend2.repository;

import com.integrador.backend2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  UserRepository extends JpaRepository<User, Integer> {
}
