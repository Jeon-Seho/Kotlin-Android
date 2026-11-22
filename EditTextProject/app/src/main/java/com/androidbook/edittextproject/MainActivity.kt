package com.androidbook.edittextproject

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var nameObj: EditText
    lateinit var passwordObj: EditText
    lateinit var emailObj: EditText
    lateinit var dateObj: EditText
    lateinit var phonenoObj: EditText
    lateinit var resultObj: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        nameObj = findViewById(R.id.edtName)
        passwordObj = findViewById(R.id.edtPasswd)
        emailObj = findViewById(R.id.edtEmail)
        dateObj = findViewById(R.id.edtDate)
        phonenoObj = findViewById(R.id.edtPhone)
        resultObj = findViewById(R.id.txtResult)
    }

    fun onButtonClick(view : View?) {
        if (nameObj.text.toString().isEmpty() ||
            passwordObj.text.toString().isEmpty() ||
            emailObj.text.toString().isEmpty() ||
            dateObj.text.toString().isEmpty() ||
            phonenoObj.text.toString().isEmpty()) {
            resultObj.text = "모든 항목을 입력해 주세요"
        } else {
            resultObj.setText("성명 - ${nameObj.text} \n" +
                            "비밀번호 - ${passwordObj.text} \n" +
                            "이메일 - ${emailObj.text} \n" +
                            "생년월일 - ${dateObj.text} \n" +
                            "연락처 - ${phonenoObj.text}")
        }
    }
}