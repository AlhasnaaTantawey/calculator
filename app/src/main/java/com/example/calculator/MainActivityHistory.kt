package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.calculator.databinding.ActivityMainHistoryBinding

class MainActivityHistory : AppCompatActivity() {
    private lateinit var binding: ActivityMainHistoryBinding
    private  val myviewModel:HistoryViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val recyclerview=  binding.recyclerview
        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(this)
       // var myviewModel = ViewModelProvider(this).get(HistoryViewModel::class.java)
        myviewModel.list.observe(this){
            var adapter=MyRecyclerViewAdapter(it)
            // Setting the Adapter with the recyclerview
            recyclerview.adapter=adapter
        }


    }
}