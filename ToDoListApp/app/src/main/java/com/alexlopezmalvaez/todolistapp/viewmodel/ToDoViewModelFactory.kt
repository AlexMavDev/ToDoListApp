package com.alexlopezmalvaez.todolistapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.alexlopezmalvaez.todolistapp.data.repository.ToDoRepository

@Suppress("UNCHECKED_CAST")
class ToDoViewModelFactory(
    private val repository: ToDoRepository
) : ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ToDoListViewModel(repository) as T
    }

}