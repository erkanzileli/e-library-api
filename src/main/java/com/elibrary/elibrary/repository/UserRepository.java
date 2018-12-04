package com.elibrary.elibrary.repository;

import com.elibrary.elibrary.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

}
