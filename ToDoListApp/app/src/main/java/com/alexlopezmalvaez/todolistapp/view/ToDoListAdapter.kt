package com.alexlopezmalvaez.todolistapp.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.alexlopezmalvaez.todolistapp.R
import com.alexlopezmalvaez.todolistapp.data.model.ToDoModel

class ToDoListAdapter(
    private val toDos: List<ToDoModel>,
    private val listener: ToDoListRecyclerViewClickListener
) : RecyclerView.Adapter<ToDoListViewHolder> () {

    override fun getItemCount() = toDos.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ToDoListViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.todo_card,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ToDoListViewHolder, position: Int) {
        holder.todoCardBinding.toDo = toDos[position]
        holder.todoCardBinding.cbCompleted.setOnClickListener{
            listener.onToDoListRecyclerViewClickListener(holder.todoCardBinding.toDoCardView, holder.todoCardBinding.cbCompleted, toDos[position], position)
        }
    }

}