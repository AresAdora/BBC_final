package com.example.demo.Repository;

import com.example.demo.entity.User;
import org.hibernate.engine.spi.ManagedEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByPassword(String email);
}
