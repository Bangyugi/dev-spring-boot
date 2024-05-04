package com.group2.website.repository;

import com.group2.website.entity.User;
import com.group2.website.objects.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findUserByEmail(String email);

    Optional<User> findUserByUsername(String username);
}
