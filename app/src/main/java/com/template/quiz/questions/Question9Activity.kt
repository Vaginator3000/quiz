package com.template.quiz.questions

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.template.quiz.LivesManager
import com.template.quiz.LoseActivity
import com.template.quiz.QuestionManager
import com.template.quiz.R
import kotlinx.android.synthetic.main.activity_question9.*

class Question9Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question9)

        setOnClicks()

        checkLivesCount()
    }

    private fun checkLivesCount() {
        when (LivesManager.getLivesCount()) {
            1 -> {
                live1.visibility = View.GONE
                live2.visibility = View.GONE
            }
            2 -> live1.visibility = View.GONE
        }
    }

    private fun makeToast(correct: Boolean) {
        if (correct)
            Toast.makeText(this, "Yep", Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(this, "Nope", Toast.LENGTH_SHORT).show()
    }

    private fun delLive() {
        when (LivesManager.getLivesCount()) {
            1 -> {
                LivesManager.delLive(live3)
                startActivity(Intent(this, LoseActivity::class.java))
            }
            2 -> LivesManager.delLive(live2)
            3 -> LivesManager.delLive(live1)
        }
    }

    private fun setOnClicks() {
        answ1.setOnClickListener {
            if (1 == QuestionManager.getAnswer(9))
                actionsIfAnswerIsCorrent()
            else
                actionsIfAnswerIsWrong(it)
        }

        answ2.setOnClickListener {
            if (2 == QuestionManager.getAnswer(9))
                actionsIfAnswerIsCorrent()
            else
                actionsIfAnswerIsWrong(it)
        }

        answ3.setOnClickListener {
            if (3 == QuestionManager.getAnswer(9))
                actionsIfAnswerIsCorrent()
            else
                actionsIfAnswerIsWrong(it)
        }

        answ4.setOnClickListener {
            if (4 == QuestionManager.getAnswer(9))
                actionsIfAnswerIsCorrent()
            else
                actionsIfAnswerIsWrong(it)

        }
    }

    private fun actionsIfAnswerIsCorrent() {
        QuestionManager.getNextQuestion(this)
    }

    private fun actionsIfAnswerIsWrong(view: View) {
        view.alpha = 0.5f
        showAnswDialog()
    }

    private fun showAnswDialog() {
        val answer = "The Union Cycliste Internationale or International Cycling Union is the governing body of Cycling in the world."
        val dialogClickListener =
            DialogInterface.OnClickListener { dialog, which ->
                when (which) {
                    DialogInterface.BUTTON_POSITIVE -> delLive()
                    DialogInterface.BUTTON_NEUTRAL -> delLive()
                }
            }

        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setTitle("Wrong!").setMessage(answer).setPositiveButton("OK", dialogClickListener).setOnCancelListener { delLive() }.show()
    }
}