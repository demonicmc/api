package com.journaler.api.repository

import com.journaler.api.data.Note
import org.springframework.data.repository.CrudRepository

interface NoteRepository: CrudRepository<Note, String> {
    fun findByTitle(title: String): Iterable<Note>
}