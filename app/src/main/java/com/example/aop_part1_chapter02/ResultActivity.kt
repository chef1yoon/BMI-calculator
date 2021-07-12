package com.example.aop_part1_chapter02

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.pow

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val height = intent.getIntExtra("height", 0)
        val weight = intent.getIntExtra("weight", 0)

        val bmi = weight / (height / 100.0).pow(2.0)
        
        val resultText = when{
            bmi >= 35.0 ->"고도 비만"
            bmi >= 30.0 ->"중정도 비만"
            bmi >= 25.0 ->"경도 비만"
            bmi >= 23.0 ->"과체중"
            bmi >= 18.5 ->"정상"
            else ->"저체중"
        }

        // 여기서 이름을 제대로 추가하는것이 중요합니다. 컴포넌트들이 많아지면 햇갈리는 일이 없기 때문입니다.
        val resultValueTextView = findViewById<TextView>(R.id.bmiResultTextView)
        val resultStringTextView = findViewById<TextView>(R.id.resultTextView)

        resultValueTextView.text = bmi.toString()
        resultStringTextView.text = resultText
    }
}