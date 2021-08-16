package com.template.quiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setOnClicks()
    }

    private fun setOnClicks() {
        btnExit.setOnClickListener {
            finishAffinity()
        }

        btnStart.setOnClickListener {
            QuestionManager.getNextQuestion(this)
        }
    }
}