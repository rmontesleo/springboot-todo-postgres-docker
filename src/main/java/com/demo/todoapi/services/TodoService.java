package com.demo.todoapi.services;

import com.demo.todoapi.dto.PostTodo;
import com.demo.todoapi.dto.PutTodo;
import com.demo.todoapi.entities.Todo;
import com.demo.todoapi.repositories.TodoRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class TodoService {

    private final TodoRepository todoRepository;

    public List<Todo> getAllTodos(){
        return todoRepository.findAll();
    }

    public List<Todo> getUserTodos( final long userId ){
        return todoRepository.findByCreatedBy(userId);
    }

    public List<Todo> getUserTodosByStatus( final long userId,  final boolean status ){
        return todoRepository.findByCreatedByAndCompleted(userId, status);
    }

    public Optional<Todo> getUserTodoById( final long userId, final long todoId ){
        return todoRepository.findByCreatedByAndTodoId( userId, todoId);
    }

    public Todo saveTodo( final long userId, final PostTodo postTodo){
        Todo todo = Todo.builder()
                .createdBy(userId)
                .createdAt(LocalDateTime.now() )
                .completed( false )
                .title(  postTodo.title() )
                .description( postTodo.description() )
                .build();
        return  todoRepository.save(todo);
    }

    @Transactional
    public boolean deleteTodo( final long userId, final long todoId ){
        long numberOfDeletedRecords = todoRepository.deleteByCreatedByAndTodoId( userId, todoId);
        return  numberOfDeletedRecords == 1;
    }


    public Optional<Todo> updateTodo(final long userId,  final long todoId, final PutTodo todo){
        return getUserTodoById( userId, todoId)
                .map( wantedTodo ->{
                    wantedTodo.setTitle( todo.title() );
                    wantedTodo.setDescription( todo.description() );
                    wantedTodo.setCompleted( todo.completed() );
                    wantedTodo.setUpdatedAt( LocalDateTime.now() );
                    return todoRepository.save(wantedTodo);
                });
    }

}
