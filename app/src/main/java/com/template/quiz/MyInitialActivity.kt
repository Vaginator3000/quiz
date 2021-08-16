package com.template.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MyInitialActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.initial_activity)
        startActivity(Intent(this, MainActivity::class.java))
    }
}