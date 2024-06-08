package com.example.snapchatsplashscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2

class ViewPagerActivity : AppCompatActivity() {
    // Step 1: Declare all variables
    private lateinit var viewPager: ViewPager2
    private lateinit var pagerAdapter: ViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager)

        // Step 6: Set Adapter
        viewPager = findViewById(R.id.viewPager)
        pagerAdapter = ViewPagerAdapter()
        viewPager.adapter = pagerAdapter
    }
}

// Step 2: Create ViewPagerAdapter
class ViewPagerAdapter : RecyclerView.Adapter<ViewHolder>() {
    // Step 4: Create a list
    private var itemList = listOf("Software Developer", "Public Speaker", "Content Creator")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.page_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]
        holder.bind(item)
    }

    // Step 5: Implement members
}

// Step 3: Create ViewHolder class
class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private var pagerText: TextView = itemView.findViewById(R.id.pagertext)

    fun bind(item: String) {
        pagerText.text = item
    }
}
