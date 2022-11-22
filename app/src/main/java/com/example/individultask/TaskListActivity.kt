package com.example.individultask

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.SharedPreferences
import android.view.View
import android.widget.EditText

const val APP_PREFERENCES_TASKS: String = "APP_PREFERENCES_TASKS"

const val PREF_FIRST_DEAL_TEXT_VALUE = "PREF_FIRST_DEAL_TEXT_VALUE"
const val PREF_FIRST_DEAL_DATE_TEXT_VALUE = "PREF_FIRST_DEAL_DATE_TEXT_VALUE"
const val PREF_FIRST_DEAL_DISCRIPTION_TEXT_VALUE = "PREF_FIRST_DEAL_DISCRIPTION_TEXT_VALUE"
const val PREF_FIRST_DEAL_TIME_TEXT_VALUE = "PREF_FIRST_DEAL_TIME_TEXT_VALUE"

const val PREF_SECOND_DEAL_TEXT_VALUE = "PREF_SECOND_DEAL_TEXT_VALUE"
const val PREF_SECOND_DEAL_DATE_TEXT_VALUE = "PREF_SECOND_DEAL_DATE_TEXT_VALUE"
const val PREF_SECOND_DEAL_DISCRIPTION_TEXT_VALUE = "PREF_SECOND_DEAL_DISCRIPTION_TEXT_VALUE"
const val PREF_SECOND_DEAL_TIME_TEXT_VALUE = "PREF_SECOND_DEAL_TIME_TEXT_VALUE"

const val PREF_THIRD_DEAL_TEXT_VALUE = "PREF_THIRD_DEAL_TEXT_VALUE"
const val PREF_THIRD_DEAL_DATE_TEXT_VALUE = "PREF_THIRD_DEAL_DATE_TEXT_VALUE"
const val PREF_THIRD_DEAL_DISCRIPTION_TEXT_VALUE = "PREF_THIRD_DEAL_DISCRIPTION_TEXT_VALUE"
const val PREF_THIRD_DEAL_TIME_TEXT_VALUE = "PREF_THIRD_DEAL_TIME_TEXT_VALUE"

class TaskListActivity : AppCompatActivity() {
    lateinit var preferences: SharedPreferences

    lateinit var first_deal: EditText
    lateinit var first_deal_date: EditText
    lateinit var first_deal_discriprion: EditText
    lateinit var first_deal_time: EditText

    lateinit var second_deal: EditText
    lateinit var second_deal_date: EditText
    lateinit var second_deal_discriprion: EditText
    lateinit var second_deal_time: EditText

    lateinit var third_deal: EditText
    lateinit var third_deal_date: EditText
    lateinit var third_deal_discriprion: EditText
    lateinit var third_deal_time: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_list)
        // Инициализация

        first_deal = findViewById(R.id.first_deal)
        first_deal_date = findViewById(R.id.first_deal_date)
        first_deal_discriprion = findViewById(R.id.first_deal_discriprion)
        first_deal_time = findViewById(R.id.first_deal_time)

        second_deal = findViewById(R.id.second_deal)
        second_deal_date = findViewById(R.id.second_deal_date)
        second_deal_discriprion = findViewById(R.id.second_deal_discriprion)
        second_deal_time = findViewById(R.id.second_deal_time)

        third_deal = findViewById(R.id.third_deal)
        third_deal_date = findViewById(R.id.third_deal_date)
        third_deal_discriprion = findViewById(R.id.third_deal_discriprion)
        third_deal_time = findViewById(R.id.third_deal_time)
        // Загрузка
        first_deal.setText(preferences.getString(PREF_FIRST_DEAL_TEXT_VALUE, ""))
        first_deal_date.setText(preferences.getString(PREF_FIRST_DEAL_DATE_TEXT_VALUE, ""))
        first_deal_discriprion.setText(preferences.getString(PREF_FIRST_DEAL_DISCRIPTION_TEXT_VALUE, ""))
        first_deal_time.setText(preferences.getString(PREF_FIRST_DEAL_TIME_TEXT_VALUE, ""))

        second_deal.setText(preferences.getString(PREF_SECOND_DEAL_TEXT_VALUE, ""))
        second_deal_date.setText(preferences.getString(PREF_SECOND_DEAL_DATE_TEXT_VALUE, ""))
        second_deal_discriprion.setText(preferences.getString(PREF_SECOND_DEAL_DISCRIPTION_TEXT_VALUE, ""))
        second_deal_time.setText(preferences.getString(PREF_SECOND_DEAL_TIME_TEXT_VALUE, "19:40"))

        third_deal.setText(preferences.getString(PREF_THIRD_DEAL_TEXT_VALUE, ""))
        third_deal_date.setText(preferences.getString(PREF_THIRD_DEAL_DATE_TEXT_VALUE, ""))
        third_deal_discriprion.setText(preferences.getString(PREF_THIRD_DEAL_DISCRIPTION_TEXT_VALUE, ""))
        third_deal_time.setText(preferences.getString(PREF_THIRD_DEAL_TIME_TEXT_VALUE, ""))

    }

    fun saveButtonPush(view: View) {
        val fd = first_deal.text.toString()
        val fdd = first_deal_date.text.toString()
        val fddi = first_deal_discriprion.text.toString()
        val fdt = first_deal_time.text.toString()

        val sd = second_deal.text.toString()
        val sdd = second_deal_date.text.toString()
        val sddi = second_deal_discriprion.text.toString()
        val sdt = second_deal_time.text.toString()

        val tfd = third_deal.text.toString()
        val tfdd = third_deal_date.text.toString()
        val tfddi = third_deal_discriprion.text.toString()
        val tfdt = third_deal_time.text.toString()

        preferences.edit()
            .putString(PREF_FIRST_DEAL_TEXT_VALUE, fd)
            .putString(PREF_FIRST_DEAL_DATE_TEXT_VALUE, fdd)
            .putString(PREF_FIRST_DEAL_DISCRIPTION_TEXT_VALUE, fddi)
            .putString(PREF_FIRST_DEAL_TIME_TEXT_VALUE, fdt)
            .putString(PREF_SECOND_DEAL_TEXT_VALUE, sd) // 2nd
            .putString(PREF_SECOND_DEAL_DATE_TEXT_VALUE, sdd)
            .putString(PREF_SECOND_DEAL_DISCRIPTION_TEXT_VALUE, sddi)
            .putString(PREF_SECOND_DEAL_TIME_TEXT_VALUE, sdt)
            .putString(PREF_THIRD_DEAL_TEXT_VALUE, tfd) // 3rd
            .putString(PREF_THIRD_DEAL_DATE_TEXT_VALUE, tfdd)
            .putString(PREF_THIRD_DEAL_DISCRIPTION_TEXT_VALUE, tfddi)
            .putString(PREF_THIRD_DEAL_TIME_TEXT_VALUE, tfdt)
            .apply()
        val intent = Intent(this, GeneralActivity::class.java)
        startActivity(intent)
    }
}