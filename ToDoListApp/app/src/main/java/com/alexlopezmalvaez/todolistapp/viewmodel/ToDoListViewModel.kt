package com.alexlopezmalvaez.todolistapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alexlopezmalvaez.todolistapp.data.model.ToDoModel
import com.alexlopezmalvaez.todolistapp.data.repository.ToDoRepository
import com.alexlopezmalvaez.todolistapp.util.Coroutines
import kotlinx.coroutines.Job

class ToDoListViewModel(
    private val repository: ToDoRepository
) : ViewModel(){

    private lateinit var job: Job

    private val _todoList = MutableLiveData<List<ToDoModel>>()
    val todoList: LiveData<List<ToDoModel>> get() = _todoList


    fun getToDoList(){
        job = Coroutines.ioThenMain(
            { repository.getToDoListByUser(1) },
            { _todoList.value = it }
        )
    }

    fun onToDoStateChanged(position: Int){
        _todoList.value!![position].completed = !_todoList.value!![position].completed
    }

    fun addToDo(title: String){
        val mutableList = _todoList.value!!.toMutableList()
        mutableList.add(0,ToDoModel(1,1,title, false))
        _todoList.value = mutableList.toList()
    }

    override fun onCleared() {
        super.onCleared()
        if(::job.isInitialized) job.cancel()
    }

    fun <T> MutableLiveData<MutableList<T>>.addNewItem(item: T) {
        val oldValue = this.value ?: mutableListOf()
        oldValue.add(0, item)
        this.value = oldValue
    }

}