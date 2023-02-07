package com.demo.todoapi.repositories;

import com.demo.todoapi.entities.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Test on http://localhost:8080/api/todoapp/jib/h2-console
 */
public interface TodoRepository extends JpaRepository<Todo,Long> {

    List<Todo> findByCreatedBy(  final long userId  );

    List<Todo> findByCreatedByAndCompleted( final long userId, boolean isCompleted );

    Optional<Todo> findByCreatedByAndTodoId( final long userId, long todoId  );

    long deleteByCreatedByAndTodoId( final long  createdBy, long todoId);


}
