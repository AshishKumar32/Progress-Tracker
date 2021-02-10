package com.example.progresstracker.loginreg

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.progresstracker.admin.project.Project_admin_activity
import com.example.progresstracker.R
import com.example.progresstracker.admin.admin_dashboard
import kotlinx.android.synthetic.main.activity_admin_login.*

class Admin_login_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_login)
        button_admin_login.setOnClickListener {
            val intent = Intent(this, admin_dashboard::class.java)
            startActivity(intent)
        }

    }
}