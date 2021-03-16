package com.alexlopezmalvaez.todolistapp.data.model

import java.lang.reflect.Constructor

data class ToDoModel (
    var id: Int,
    var userId: Int,
    var title: String,
    var completed: Boolean
)