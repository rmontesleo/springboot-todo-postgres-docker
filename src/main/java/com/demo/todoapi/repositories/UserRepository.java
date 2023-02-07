package com.demo.todoapi.repositories;

import com.demo.todoapi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Test on http://localhost:8080/api/todoapp/jib/h2-console
 */
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByUserName( final String userName);

    Optional<User> findByUserNameAndPassword( final String userName, final String password );
}
