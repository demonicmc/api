package com.journaler.api.repository

import com.journaler.api.data.Todo
import org.springframework.data.repository.CrudRepository
import org.springframework.data.jpa.repository.Query

interface TodoRepository: CrudRepository<Todo, String>{

    @Query("from Todo t where t.shedule > ?1")
    fun findSheduledLaterThane(date: Long): Iterable<Todo>
}
