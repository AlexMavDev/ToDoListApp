package com.alexlopezmalvaez.todolistapp.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.alexlopezmalvaez.todolistapp.R
import com.alexlopezmalvaez.todolistapp.data.repository.ToDoRepository
import com.alexlopezmalvaez.todolistapp.todoapi.ToDoClient
import com.alexlopezmalvaez.todolistapp.viewmodel.ToDoListViewModel
import com.alexlopezmalvaez.todolistapp.viewmodel.ToDoViewModelFactory

class ToDoListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.todo_list_activity)
    }

    fun onAddButtonClicked(view: View){
        //viewModel.addToDo()
    }
}