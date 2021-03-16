package com.alexlopezmalvaez.todolistapp.todoapi

import com.alexlopezmalvaez.todolistapp.data.model.ToDoModel
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ToDoClient: ToDoAPIRequests {

    companion object{
        var BASE_URL : String = "http://jsonplaceholder.typicode.com"
         operator fun invoke() : ToDoClient {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ToDoClient::class.java)
        }
    }

}