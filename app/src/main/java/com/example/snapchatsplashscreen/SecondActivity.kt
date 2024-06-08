package com.example.snapchatsplashscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import android.widget.ListView
import android.widget.Toast

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val listView: ListView = findViewById(R.id.listView)
        val listItems = arrayOf("Read a Book", "Go to Gym", "Eat Healthy", "Stay Hydrated",
            "Learn Kotlin", "Build multiple Projects", "Practice DSA", "Apply for jobs")

        val listAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listItems)
        listView.adapter = listAdapter

        listView.setOnItemClickListener { parent, view, id, position ->
            val selectedItem =parent.getItemAtPosition(position.toInt()) as String
            Toast.makeText(this, "You have CLicked on : $selectedItem", Toast.LENGTH_SHORT).show()

        }
    }
}