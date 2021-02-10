package com.example.progresstracker.admin.commitHistory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.progresstracker.DataSourceCommits
import com.example.progresstracker.DataSourceProjectList
import com.example.progresstracker.R
import com.example.progresstracker.TopSpacingItemDecoration
import com.example.progresstracker.admin.project.ProjectItemAdapter
import com.example.progresstracker.admin.projectDetails.Project_details_admin
import com.google.android.material.transition.platform.MaterialContainerTransform
import com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback
import kotlinx.android.synthetic.main.activity_commit_history.*
import kotlinx.android.synthetic.main.activity_project_admin.*

class Commit_history : AppCompatActivity(), CommitHistoryAdapter.OnItemClickListener {
    private lateinit var commitHistoryAdapter : CommitHistoryAdapter
    override fun onCreate(savedInstanceState: Bundle?) {




        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_commit_history)

        initRecyclerView()
        addDataSet()
        icon_back_commit_history.setOnClickListener{
            finish()
        }
    }
    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
    private fun addDataSet(){
        val data = DataSourceCommits.createDataSet()
        commitHistoryAdapter.submitList(data)
    }
    private fun initRecyclerView(){
        recyclerview_commit_history.apply {
            layoutManager= LinearLayoutManager(this@Commit_history)
            val topSpacingDecoration = TopSpacingItemDecoration(1)
            addItemDecoration(topSpacingDecoration)
            commitHistoryAdapter = CommitHistoryAdapter(this@Commit_history)
            adapter = commitHistoryAdapter

        }
    }

    override fun onItemClick(position: Int) {
        Toast.makeText(this, "Item $position clicked", Toast.LENGTH_SHORT).show()
    }
}