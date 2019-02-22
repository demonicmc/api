package com.journaler.api.service

import com.journaler.api.data.Todo
import com.journaler.api.data.TodoDTO
import com.journaler.api.repository.TodoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service
import java.util.*

@Service("Todo Service")
class TodoService {

    @Autowired
    lateinit var repository: TodoRepository

    fun getTodos(): Iterable<TodoDTO> = repository.findAll().map { it -> TodoDTO(it) }

    fun insertTodo(todo: TodoDTO): TodoDTO = TodoDTO(
            repository.save(
                    Todo(
                            title = todo.title,
                            message = todo.message,
                            location = todo.loaction,
                            shedule = todo.schedule
                    )
            )
    )

    fun deleteTodo(id: String) = repository.deleteById(id)

    fun updateTodo(todoDto: TodoDTO): TodoDTO {
        var todo = repository.findById(todoDto.id).get()
        todo.title = todoDto.title
        todo.message = todoDto.message
        todo.location = todoDto.loaction
        todo.shedule = todoDto.schedule
        todo.modified = Date()
        todo = repository.save(todo)
        return TodoDTO(todo)
    }
}