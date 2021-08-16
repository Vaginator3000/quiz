package com.template.quiz

import android.content.Context
import android.content.Intent
import com.template.quiz.questions.*
import kotlin.random.Random

object QuestionManager {
    private val questions: BooleanArray = BooleanArray(10) { false }

    private val answers = arrayOf(1,4,3,4,3,4,1,3,1,2)

    fun getAnswer(questionNum: Int) =
        answers[questionNum - 1]

    fun getNextQuestion(context: Context) {
        val num = generateQuestionNum()
        if (num == 0)
            context.startActivity(Intent(context, WinActivity::class.java))

        startQuestionActivityByNum(num, context)
    }

    private fun startQuestionActivityByNum(num: Int, context: Context) {
        when(num) {
            1 -> context.startActivity(Intent(context, Question1Activity::class.java))
            2 -> context.startActivity(Intent(context, Question2Activity::class.java))
            3 -> context.startActivity(Intent(context, Question3Activity::class.java))
            4 -> context.startActivity(Intent(context, Question4Activity::class.java))
            5 -> context.startActivity(Intent(context, Question5Activity::class.java))
            6 -> context.startActivity(Intent(context, Question6Activity::class.java))
            7 -> context.startActivity(Intent(context, Question7Activity::class.java))
            8 -> context.startActivity(Intent(context, Question8Activity::class.java))
            9 -> context.startActivity(Intent(context, Question9Activity::class.java))
            10 -> context.startActivity(Intent(context, Question10Activity::class.java))
        //    else -> context.startActivity(Intent(context, WinActivity::class.java))
        }

    }

    private fun generateQuestionNum(): Int {
        if (checkAllQuestionsUsed()) return 0

        var num : Int
        do {
            num = Random.nextInt(10)
        } while (questions[num])
        questions[num] = true

        return num + 1
    }

    private fun checkAllQuestionsUsed() : Boolean {
        questions.forEach {
            if (!it) return false
        }
        return true
    }
}