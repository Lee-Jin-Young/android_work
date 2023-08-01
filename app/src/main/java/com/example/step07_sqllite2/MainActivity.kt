package com.example.step07_sqllite2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.widget.Toast
import com.example.step07_sqllite2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnClickListener {
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.sendBtn.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        val msg = binding.inputMsg.text
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}