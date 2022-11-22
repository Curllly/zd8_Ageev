package com.example.individultask

import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.Display.Mode
import android.view.View
import android.widget.EditText

const val APP_PREFERENCES = "APP_PREFERENCES"
const val PREF_LOGIN_TEXT_VALUE = "PREF_LOGIN_TEXT_VALUE"
const val PREF_EMAIL_TEXT_VALUE = "PREF_EMAIL_TEXT_VALUE"

class MainActivity : AppCompatActivity() {

    lateinit var preferences: SharedPreferences
    lateinit var usernameField: EditText
    lateinit var emailField: EditText
    lateinit var passwordField: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        preferences = getSharedPreferences(APP_PREFERENCES, MODE_PRIVATE)

        usernameField = findViewById(R.id.usernameField)
        emailField = findViewById(R.id.emailField)
        passwordField = findViewById(R.id.passwordField)

        usernameField.setText(preferences.getString(PREF_LOGIN_TEXT_VALUE, ""))
        emailField.setText(preferences.getString(PREF_EMAIL_TEXT_VALUE, ""))
    }

    fun registerButtonPush(view: View) {
        if (usernameField.text.isEmpty()
            || emailField.text.isEmpty()
            || passwordField.text.isEmpty()
        ) {
            val alert = AlertDialog.Builder(this)
                .setTitle("Ошибка")
                .setMessage("У вас есть незаполненные поля")
                .setPositiveButton("Ок", null)
                .create()
                .show()
        }
        else {
            val userNameValue = usernameField.text.toString()
            val emailValue = emailField.text.toString()
            preferences.edit()
                .putString(PREF_LOGIN_TEXT_VALUE, userNameValue)
                .putString(PREF_EMAIL_TEXT_VALUE, emailValue)
                .apply()

            val intent = Intent(this, GeneralActivity::class.java)
            startActivity(intent)
        }
    }
}