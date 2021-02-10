package com.example.progresstracker

import com.example.progresstracker.models.FeatureItem


class DataSourceFeatureList {
    companion object{

        fun createDataSet(): ArrayList<FeatureItem>{
            val list = ArrayList<FeatureItem>()
            list.add(
                FeatureItem(
                    "Kotlin Chat",
                    "Medium",
                    "A chat application built for android, written in Kotlin",
                    "5 People",
                    "65%"

                )
            )
            list.add(
                FeatureItem(
                    "Bookemon",
                    "Low",
                    "A movie ticket booking website built using Django Framework and Bootstrap for frontend",
                    "2 People",
                    "88%"
                )
            )

            list.add(
                FeatureItem(
                    "Weather Forecast",
                    "Low",
                    "A weather forecasrt website written in Node.js and using openweatherbit.io API",
                    "1 Person",
                    "96%"
                )
            )
            list.add(
                FeatureItem(
                    "Simple Chatroom",
                    "Low",
                    "A chatroom website built using Node.js(express.js) and socket.io",
                    "1 Person",
                    "100%"
                )
            )
            list.add(
                FeatureItem(
                    "Ez Notes",
                    "Medium",
                    "A simple note taking app and website (devlopment not started yet)",
                    "0 People",
                    "0%"
                )
            )
            list.add(
                FeatureItem(
                    "Progress tracker",
                    "High",
                    "An android app to track the progress of different projects and features within them in a tech company",
                    "12 People",
                    "25%"
                )
            )
            list.add(
                FeatureItem(
                    "React.js",
                    "Medium",
                    "Just a reminder to learn React.js",
                    "1 Person",
                    "8%"
                )
            )
            list.add(
                FeatureItem(
                    "Java",
                    "Medium",
                    "Just a reminder to learn Java",
                    "1 Person",
                    "60%"
                )
            )
            list.add(
                FeatureItem(
                    "Javascript",
                    "Medium",
                    "Just a reminder to learn Javascript",
                    "1 Person",
                    "40%"
                )
            )
            return list
        }
    }
}