package com.example.snapchatsplashscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast

class SpinnerActivity : AppCompatActivity() {

    private lateinit var spinner : Spinner
    private var isSpinnerInitialized = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spinner)

        spinner = findViewById(R.id.spinner)

        val listItems = listOf("Morning", "Afternoon", "Evening", "Night")

        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, listItems)
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = arrayAdapter


        spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val selectedItem = parent.getItemAtPosition(position).toString()
                if(isSpinnerInitialized){
                    Toast.makeText(this@SpinnerActivity,"You have selected $selectedItem", Toast.LENGTH_SHORT).show()
                }else{
                    isSpinnerInitialized=true
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }
    }
}