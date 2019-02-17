package com.journaler.api.data

data class Todo(
        var id: String = "",
        var title: String,
        var message: String,
        var shedule: Long,
        var location: String = ""
)