package com.example.progresstracker

import com.example.progresstracker.models.ProjectItem

class DataSourceProjectList {
    companion object{

        fun createDataSet(): ArrayList<ProjectItem>{
            val list = ArrayList<ProjectItem>()
            list.add(
                    ProjectItem(
                            "Kotlin Chat",
                            "Medium",
                            "https://raw.githubusercontent.com/mitchtabian/Blog-Images/master/digital_ocean.png",
                            "5 People",
                            "65%"

                    )
            )
            list.add(
                    ProjectItem(
                            "Bookemon",
                            "Low",
                            "https://raw.githubusercontent.com/mitchtabian/Kotlin-RecyclerView-Example/json-data-source/app/src/main/res/drawable/time_to_build_a_kotlin_app.png",
                            "2 People",
                            "88%"
                    )
            )

            list.add(
                    ProjectItem(
                            "Weather Forecast",
                            "Low",
                            "https://raw.githubusercontent.com/mitchtabian/Kotlin-RecyclerView-Example/json-data-source/app/src/main/res/drawable/coding_for_entrepreneurs.png",
                            "1 Person",
                            "96%"
                    )
            )
            list.add(
                    ProjectItem(
                            "Simple Chatroom",
                            "Low",
                            "https://raw.githubusercontent.com/mitchtabian/Kotlin-RecyclerView-Example/json-data-source/app/src/main/res/drawable/freelance_android_dev_vasiliy_zukanov.png",
                            "1 Person",
                            "100%"
                    )
            )
            list.add(
                    ProjectItem(
                            "Ez Notes",
                            "Medium",
                            "https://raw.githubusercontent.com/mitchtabian/Kotlin-RecyclerView-Example/json-data-source/app/src/main/res/drawable/freelance_android_dev_donn_felker.png",
                            "0 People",
                            "0%"
                    )
            )
            list.add(
                    ProjectItem(
                            "Progress tracker",
                            "High",
                            "https://raw.githubusercontent.com/mitchtabian/Kotlin-RecyclerView-Example/json-data-source/app/src/main/res/drawable/work_life_balance.png",
                            "12 People",
                            "25%"
                    )
            )
            list.add(
                    ProjectItem(
                            "React.js",
                            "Medium",
                            "https://raw.githubusercontent.com/mitchtabian/Kotlin-RecyclerView-Example/json-data-source/app/src/main/res/drawable/fullsnack_developer.png",
                            "1 Person",
                            "8%"
                    )
            )
            list.add(
                    ProjectItem(
                            "Java",
                            "Medium",
                            "https://raw.githubusercontent.com/mitchtabian/Kotlin-RecyclerView-Example/json-data-source/app/src/main/res/drawable/javascript_expert_wes_bos.png",
                            "1 Person",
                            "60%"
                    )
            )
            list.add(
                    ProjectItem(
                            "Javascript",
                            "Medium",
                            "https://raw.githubusercontent.com/mitchtabian/Kotlin-RecyclerView-Example/json-data-source/app/src/main/res/drawable/senior_android_engineer_kaushik_gopal.png",
                            "1 Person",
                            "40%"
                    )
            )
            return list
        }
    }
}