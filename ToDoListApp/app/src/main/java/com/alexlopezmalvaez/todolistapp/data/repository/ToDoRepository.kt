package com.alexlopezmalvaez.todolistapp.data.repository

import com.alexlopezmalvaez.todolistapp.todoapi.SafeApiRequest
import com.alexlopezmalvaez.todolistapp.todoapi.ToDoAPIRequests
import com.alexlopezmalvaez.todolistapp.todoapi.ToDoClient

class ToDoRepository(private val api: ToDoClient): SafeApiRequest() {
    suspend fun getToDoListByUser(userId: Int) = apiRequest { api.requestToDos(userId) }
}

