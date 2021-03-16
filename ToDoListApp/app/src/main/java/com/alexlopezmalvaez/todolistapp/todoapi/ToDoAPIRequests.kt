package com.alexlopezmalvaez.todolistapp.todoapi

import com.alexlopezmalvaez.todolistapp.data.model.ToDoModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Query

interface ToDoAPIRequests{

    @GET("/todos")
    suspend fun requestToDos(@Query("userId") userId: Int): Response<List<ToDoModel>>

    /*
    @PUT("/todos")
    suspend fun
     */

}