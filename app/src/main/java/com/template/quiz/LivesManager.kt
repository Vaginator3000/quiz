package com.template.quiz

import android.app.Activity
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout


object LivesManager {
    private var lives = 3

    fun delLive(view: View) {
        (view.context as Activity).runOnUiThread {
            view.visibility = View.GONE
        }
        lives--
    }

    fun restartGame() {
        lives = 3
    }

    fun getLivesCount() = lives
}