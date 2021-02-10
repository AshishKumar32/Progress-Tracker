package com.example.progresstracker.admin.project

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.progresstracker.DataSourceProjectList
import com.example.progresstracker.R
import com.example.progresstracker.TopSpacingItemDecoration
import com.example.progresstracker.admin.projectDetails.Project_details_admin
import com.example.progresstracker.models.ProjectItem
import com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback
import kotlinx.android.synthetic.main.activity_project_admin.*
import kotlinx.android.synthetic.main.project_row.*


class Project_admin_activity : AppCompatActivity(), ProjectItemAdapter.OnItemClickListener {
    private lateinit var projectItemAdapter: ProjectItemAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        window.requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)
        setExitSharedElementCallback(MaterialContainerTransformSharedElementCallback())
        window.sharedElementsUseOverlay=false

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_project_admin)
        initRecyclerView()
        addDataSet()

        icon_back_project_admin.setOnClickListener{
            finish()
        }

    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }


    private fun addDataSet(){
        val data = DataSourceProjectList.createDataSet()
        projectItemAdapter.submitList(data)
    }
    private fun initRecyclerView(){
        recyclerview_project_list_admin.apply {
            layoutManager=LinearLayoutManager(this@Project_admin_activity)
            val topSpacingDecoration = TopSpacingItemDecoration(1)
            addItemDecoration(topSpacingDecoration)
            projectItemAdapter = ProjectItemAdapter(this@Project_admin_activity)
            adapter = projectItemAdapter

        }
    }


    override fun onItemClick(position: Int, item: ProjectItem, sharedCardView: CardView) {
        val intent = Intent(this, Project_details_admin::class.java)
        intent.putExtra("PROJECT_NAME", item.name)
        //sharedCardView.transitionName=item.name
        val options = ActivityOptions.makeSceneTransitionAnimation(this@Project_admin_activity, sharedCardView, item.name)

        if (options != null) {
            startActivity(intent, options.toBundle())
        }
    }

}
