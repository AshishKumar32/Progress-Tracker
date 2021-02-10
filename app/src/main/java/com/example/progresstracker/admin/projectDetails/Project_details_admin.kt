package com.example.progresstracker.admin.projectDetails

import android.os.Bundle
import android.view.View
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.progresstracker.*
import com.example.progresstracker.R
import com.example.progresstracker.models.PeopleItem
import com.google.android.material.transition.platform.MaterialContainerTransform
import com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback
import kotlinx.android.synthetic.main.activity_project_details_admin.*
import kotlinx.android.synthetic.main.bottom_sheet_more_people.*

import kotlin.collections.ArrayList


class Project_details_admin : AppCompatActivity(),FeatureItemAdapter.OnItemClickListener {
    private lateinit var peopleAdapter: BottomSheetAdapter
    val header :MutableList<String> = ArrayList()
    val body : MutableList<MutableList<String>> = ArrayList()
    private lateinit var featureItemAdapter: FeatureItemAdapter
    override fun onCreate(savedInstanceState: Bundle?) {


        window.requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)
        window.sharedElementsUseOverlay=false

        findViewById<View>(android.R.id.content).transitionName=intent.getStringExtra("PROJECT_NAME")
        setEnterSharedElementCallback(MaterialContainerTransformSharedElementCallback())


        window.sharedElementEnterTransition = MaterialContainerTransform().apply {
            addTarget(android.R.id.content)
            duration=300L
            scrimColor=resources.getColor(R.color.colorBackground)
            fadeMode = MaterialContainerTransform.FADE_MODE_OUT
        }
        window.sharedElementReturnTransition = MaterialContainerTransform().apply {
            addTarget(android.R.id.content)
            duration= 250L
            scrimColor=resources.getColor(R.color.colorBackground)
            fadeMode = MaterialContainerTransform.FADE_MODE_IN
        }


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_project_details_admin)
        project_name_detail_admin.text=intent.getStringExtra("PROJECT_NAME")


        initRecyclerView()
        addDataSet()
        icon_back_project_detail_admin.setOnClickListener {
            finish()
        }


    }

    private fun addDataSet() {
        val data = DataSourceFeatureList.createDataSet()
        featureItemAdapter.submitList(data)
    }
    private fun initRecyclerView() {
        recyclerview_project_detail.apply {
            layoutManager = LinearLayoutManager(this@Project_details_admin)
            val topSpacingItemDecoration = TopSpacingItemDecoration(1)
            addItemDecoration(topSpacingItemDecoration)
            featureItemAdapter = FeatureItemAdapter(this@Project_details_admin,this@Project_details_admin)
            adapter = featureItemAdapter

        }
    }
    fun showMenu() {
        val items = arrayListOf(
                PeopleItem("Dev 5", R.drawable.dev_5),
                PeopleItem("Dev 6",R.drawable.dev_6),
                PeopleItem("Dev 7",R.drawable.dev_7),
                PeopleItem("Dev 8",R.drawable.dev_8)
        )
        BottomSheetMorePeople(this,items)
                .show()
    }



}

