package com.journaler.api.service

import com.journaler.api.data.Todo
import com.journaler.api.repository.TodoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service
import java.util.*

@Service("Todo Service")
class TodoService {

    @Autowired
    lateinit var repository: TodoRepository

    fun getTodos(): Iterable<Todo> = repository.findAll()

    fun insertTodo(todo: Todo): Todo = repository.save(todo)

    fun deleteTodo(id: String) = repository.deleteById(id)

    fun updateTodo(todo: Todo): Todo = repository.save(todo)
}