package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.Todo.Todo
import com.example.todolist.Todo.TodoAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val todos: ArrayList<Todo> = arrayListOf()
        val todoAdapter = TodoAdapter(todos)
        val recyclerView: RecyclerView = findViewById(R.id.rv_todo)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        recyclerView.adapter = todoAdapter

        val button: Button = findViewById(R.id.btn_todo_change)
        button.setOnClickListener {
            val todoText: String = findViewById<EditText>(R.id.et_todo).text.toString()
            todos.add(Todo(todoText,false))
            todoAdapter.notifyItemInserted(todos.size)
        }
    }
}