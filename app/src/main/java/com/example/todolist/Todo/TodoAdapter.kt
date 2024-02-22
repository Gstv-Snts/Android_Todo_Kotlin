package com.example.todolist.Todo

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.R

class TodoAdapter(private val todos: ArrayList<Todo>) :
    RecyclerView.Adapter<TodoAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvTodo: TextView
        val btnTodo: Button
        val cbTodo: CheckBox

        init {
            tvTodo = view.findViewById(R.id.tv_todo)
            btnTodo = view.findViewById(R.id.btn_todo)
            cbTodo = view.findViewById(R.id.cb_todo)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_todo_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.btnTodo.setOnClickListener {
            todos.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, todos.size)
        }
        holder.cbTodo.setOnCheckedChangeListener { _, isChecked ->
            todos[position].isChecked = isChecked
            Log.d("cb click", "onBindViewHolder: ${todos[position].toString()}")
        }
        holder.tvTodo.text = todos[position].text
    }

    override fun getItemCount() = todos.size
}