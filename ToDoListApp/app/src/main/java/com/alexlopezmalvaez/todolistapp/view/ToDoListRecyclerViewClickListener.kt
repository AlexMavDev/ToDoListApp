package com.alexlopezmalvaez.todolistapp.view

import android.view.View
import androidx.cardview.widget.CardView
import com.alexlopezmalvaez.todolistapp.data.model.ToDoModel

interface ToDoListRecyclerViewClickListener {
    fun onToDoListRecyclerViewClickListener(cardView: CardView, view: View, toDo: ToDoModel, position: Int)
}