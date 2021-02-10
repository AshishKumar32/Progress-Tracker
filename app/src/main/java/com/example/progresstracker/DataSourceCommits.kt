package com.example.progresstracker

import com.example.progresstracker.models.CommitItem

class DataSourceCommits {
    companion object{

        fun createDataSet(): ArrayList<CommitItem>{
            val list = ArrayList<CommitItem>()
            list.add(
                CommitItem(
                    "Kotlin Chat",
                    "Medium",
                    "A chat application built for android, written in Kotlin"


                )
            )
            list.add(
                CommitItem(
                    "Bookemon",
                    "Low",
                    "A movie ticket booking website built using Django Framework and Bootstrap for frontend"

                )
            )

            list.add(
                CommitItem(
                    "Weather Forecast",
                    "Low",
                    "A weather forecasrt website written in Node.js and using openweatherbit.io API"

                )
            )
            list.add(
                CommitItem(
                    "Simple Chatroom",
                    "Low",
                    "A chatroom website built using Node.js(express.js) and socket.io"

                )
            )
            list.add(
                CommitItem(
                    "Ez Notes",
                    "Medium",
                    "A simple note taking app and website (devlopment not started yet)"

                )
            )
            list.add(
                CommitItem(
                    "Progress tracker",
                    "High",
                    "An android app to track the progress of different projects and features within them in a tech company"

                )
            )
            list.add(
                CommitItem(
                    "React.js",
                    "Medium",
                    "Just a reminder to learn React.js"

                )
            )
            list.add(
                CommitItem(
                    "Java",
                    "Medium",
                    "Just a reminder to learn Java"

                )
            )
            list.add(
                CommitItem(
                    "Javascript",
                    "Medium",
                    "Just a reminder to learn Javascript"

                )
            )
            return list
        }
    }
}