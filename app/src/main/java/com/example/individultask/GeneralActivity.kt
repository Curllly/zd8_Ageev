package com.example.individultask

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class GeneralActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_general)
    }

    fun listButtonPush(view: View) {
        val intent = Intent(this, TaskListActivity::class.java)
            startActivity(intent)
    }
}