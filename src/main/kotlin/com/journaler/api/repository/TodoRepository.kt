package com.journaler.api.repository

import com.journaler.api.data.Todo
import org.springframework.data.repository.CrudRepository

interface TodoRepository: CrudRepository<Todo, String>