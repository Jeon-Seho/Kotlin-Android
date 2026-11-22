package com.androidbook.buttonproject

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var tvObj1 : TextView
    lateinit var tvObj2 : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        tvObj1 = findViewById(R.id.num1)
        tvObj2 = findViewById(R.id.num2)
    }

    fun onClickSum(View: View?) {
        var value1 = tvObj1.text.toString().toInt()
        var value2 = tvObj2.text.toString().toInt()

        var sum = value1 + value2
        Toast.makeText(applicationContext, "합계: $sum", Toast.LENGTH_LONG).show()
    }
}