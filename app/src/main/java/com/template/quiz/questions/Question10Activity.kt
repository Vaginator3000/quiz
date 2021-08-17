package com.template.quiz.questions

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.template.quiz.LivesManager
import com.template.quiz.LoseActivity
import com.template.quiz.QuestionManager
import com.template.quiz.R
import kotlinx.android.synthetic.main.activity_question10.*


class Question10Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question10)

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
            if (1 == QuestionManager.getAnswer(10))
                actionsIfAnswerIsCorrent()
            else
                actionsIfAnswerIsWrong(it)
        }

        answ2.setOnClickListener {
            if (2 == QuestionManager.getAnswer(10))
                actionsIfAnswerIsCorrent()
            else
                actionsIfAnswerIsWrong(it)
        }

        answ3.setOnClickListener {
            if (3 == QuestionManager.getAnswer(10))
                actionsIfAnswerIsCorrent()
            else
                actionsIfAnswerIsWrong(it)
        }

        answ4.setOnClickListener {
            if (4 == QuestionManager.getAnswer(10))
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
        val answer = "Dutee Chand is an Indian Professional sprinter and a current national champion in the women’s 100m. She is the third Indian woman to qualify for the Women’s 100m event at the Summer Olympic Games. Which athletics event does Jinson Johnson specialise in?"
        val dialogClickListener =
            DialogInterface.OnClickListener { dialog, which ->
                when (which) {
                    DialogInterface.BUTTON_POSITIVE -> delLive()
                    DialogInterface.BUTTON_NEUTRAL -> delLive()
                }
            }

        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setTitle("Wrong!").setMessage(answer).setPositiveButton("OK", dialogClickListener).setOnCancelListener() { delLive() }.show()
    }
}