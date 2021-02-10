package com.example.progresstracker

import com.example.progresstracker.models.PeopleItem

class DataSourcePeopleList {
    companion object{

        fun createDataSet(): ArrayList<PeopleItem>{
            val list = ArrayList<PeopleItem>()
            list.add(
                    PeopleItem(
                            "Dev 1",R.drawable.dev_1
                    )
            )
            list.add(
                    PeopleItem(
                            "Dev 2",R.drawable.dev_2
                    )
            )

            list.add(
                    PeopleItem(
                            "Dev 3",R.drawable.dev_3
                    )
            )
            list.add(
                    PeopleItem(
                            "Dev 4",R.drawable.dev_4
                    )
            )

            return list
        }
    }
}