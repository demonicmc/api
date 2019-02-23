package com.journaler.api.controller

import com.journaler.api.data.Todo
import com.journaler.api.data.TodoDTO
import com.journaler.api.service.TodoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.http.MediaType
import org.springframework.http.MediaTypeEditor
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Payload

@RestController
@RequestMapping("/todos")
class TodoController {

    @Autowired
    private lateinit var service: TodoService

    /**
     * Get todos.
     */
    @GetMapping(
            produces = arrayOf(MediaType.APPLICATION_JSON_VALUE)
    )
    fun getTodos() = service.getTodos()

    /**
     * Insert item.
     * It consumes JSON, that is: request body Todo.
     */
    @PutMapping(
            produces = arrayOf(MediaType.APPLICATION_JSON_VALUE),
            consumes = arrayOf(MediaType.APPLICATION_JSON_VALUE)
    )
    fun insertTodo(
            @RequestBody todo: TodoDTO
    ) = service.insertTodo(todo)

    /**
     * Remove item by Id.
     * We introduced path variable for Id to pass.
     */
    @DeleteMapping(
            value = "/{id}",
            produces = arrayOf(MediaType.APPLICATION_JSON_VALUE)
    )
    fun deleteTodd(@PathVariable(name = "id") id: String) = service.deleteTodo(id)

    /**
     * Update item.
     * It consumes JSON, that is: request body Todo.
     * As result it returns updated Todo.
     */
    @PostMapping(
            produces = arrayOf(MediaType.APPLICATION_JSON_VALUE),
            consumes = arrayOf(MediaType.APPLICATION_JSON_VALUE)
    )
    fun updateTodo(@RequestBody todo: TodoDTO) = service.updateTodo(todo)

    fun getTodosLaterThan(
            @RequestBody payload: TodoLaterThanRequest
    ): Iterable<TodoDTO> = service.getSheduledLaterThan(payload.date)
}
