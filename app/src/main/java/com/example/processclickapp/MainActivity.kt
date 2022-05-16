package com.example.processclickapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.processclickapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var counter: Int = 0
    private val KEY_COUNT = "COUNT"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val textView: TextView = binding.textView
        if(savedInstanceState != null){
            counter = savedInstanceState.getInt(KEY_COUNT, 0)
            textView.setText("$counter")
        }

        val buttonCounter: Button =binding.buttonCounter
        buttonCounter.setOnClickListener {
            textView.text ="${++counter}"
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_COUNT, counter)
    }
}