package com.template.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_win.*

class WinActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_win)

        btnRestart.setOnClickListener {
            LivesManager.restartGame()
            QuestionManager.restartGame()
            val context = this
            finish()
            startActivity(Intent(context, MainActivity::class.java))
        }
    }
}