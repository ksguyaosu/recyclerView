package com.example.android.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val adapter = BasketballAdapter()
    private val imageIdList = listOf(R.drawable.irving, R.drawable.kd, R.drawable.lebron, R.drawable.steph)
    private val titleIdList = listOf("Kyrie Irving", "Kevin Durant", "LeBron James", "Steph Curry")
    private var index = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init() {
        binding.apply {
            rcView.layoutManager = GridLayoutManager(this@MainActivity, 2)
            rcView.adapter = adapter
            buttonAdd.setOnClickListener {
                if(index > 3) index = 0
                val player = Player(imageIdList[index], titleIdList[index])
                adapter.addPlayer(player)
                index++
            }
        }
    }
}