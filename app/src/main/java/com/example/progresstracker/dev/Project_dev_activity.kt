package com.example.progresstracker.dev

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.progresstracker.R
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item

import kotlinx.android.synthetic.main.activity_project_dev.*

class Project_dev_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_project_dev)
        val adapter = GroupAdapter<GroupieViewHolder>()
        recyclerview_project_list_dev.adapter = adapter
        adapter.add(ProjectItemDev())
        adapter.add(ProjectItemDev())
        adapter.add(ProjectItemDev())

        icon_back_project_dev.setOnClickListener{
            finish()
        }
    }
}
class ProjectItemDev : Item<GroupieViewHolder>(){

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {

    }
    override fun getLayout(): Int {
        return R.layout.project_row
    }



}