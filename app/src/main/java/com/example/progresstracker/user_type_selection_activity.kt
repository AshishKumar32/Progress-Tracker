package com.example.progresstracker

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.example.progresstracker.loginreg.Admin_login_activity
import com.example.progresstracker.loginreg.Dev_login_activity
import kotlinx.android.synthetic.main.activity_user_type_selection.*


class user_type_selection_activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_type_selection)
        imageview_admin_login.setOnClickListener{
            val intent = Intent(this, Admin_login_activity::class.java)
            val options = ActivityOptions.makeSceneTransitionAnimation(this,imageview_admin_login,"admin_image")

            startActivity(intent,options.toBundle())

        }
        imageview_dev_login.setOnClickListener{
            val intent = Intent(this, Dev_login_activity::class.java)
            val options = ActivityOptions.makeSceneTransitionAnimation(this,imageview_dev_login,"profile_image")

            startActivity(intent,options.toBundle())

        }
    }
}