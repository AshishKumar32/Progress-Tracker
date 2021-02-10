package com.example.progresstracker.loginreg

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.progresstracker.dev.Project_dev_activity
import com.example.progresstracker.R
import kotlinx.android.synthetic.main.activity_dev_login.*

class Dev_login_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dev_login)
        button_dev_login.setOnClickListener {
            val intent = Intent(this, Project_dev_activity::class.java)
            startActivity(intent)
        }

    }
}