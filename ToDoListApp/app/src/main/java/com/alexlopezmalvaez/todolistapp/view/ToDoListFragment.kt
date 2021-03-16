package com.alexlopezmalvaez.todolistapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.alexlopezmalvaez.todolistapp.R
import com.alexlopezmalvaez.todolistapp.data.model.ToDoModel
import com.alexlopezmalvaez.todolistapp.data.repository.ToDoRepository
import com.alexlopezmalvaez.todolistapp.todoapi.ToDoClient
import com.alexlopezmalvaez.todolistapp.viewmodel.ToDoListViewModel
import com.alexlopezmalvaez.todolistapp.viewmodel.ToDoViewModelFactory
import kotlinx.android.synthetic.main.todo_list_fragment.*

class ToDoListFragment : Fragment(), ToDoListRecyclerViewClickListener{

    private lateinit var factory: ToDoViewModelFactory
    private lateinit var viewModel: ToDoListViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.todo_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val api = ToDoClient()
        val repository = ToDoRepository(api)

        factory = ToDoViewModelFactory(repository)
        viewModel = ViewModelProviders.of(this,factory).get(ToDoListViewModel::class.java)

        viewModel.getToDoList()
        viewModel.todoList.observe(viewLifecycleOwner, Observer { todos ->
            recycler_view_todos.also {
                it.layoutManager = LinearLayoutManager(requireContext())
                it.setHasFixedSize(true)
                it.adapter = ToDoListAdapter(todos, this)
            }
        })

    }

    override fun onToDoListRecyclerViewClickListener(cardView: CardView, view: View, toDo: ToDoModel, position: Int) {
        when(view.id){
            R.id.cb_completed -> {
                if(toDo.completed){
                    cardView.setBackgroundColor(resources.getColor(R.color.no_completed_color))
                } else {
                    cardView.setBackgroundColor(resources.getColor(R.color.completed_color))
                }
                viewModel.onToDoStateChanged(position)
            }
        }
    }
}