package com.template.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_lose.*

class LoseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lose)

        btnRestart.setOnClickListener {
            LivesManager.restartGame()
            QuestionManager.restartGame()
            val context = this
            finish()
            startActivity(Intent(context, MainActivity::class.java))

        }
    }

}