package com.example.progresstracker.admin.projectDetails

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.ContextThemeWrapper
import androidx.recyclerview.widget.GridLayoutManager
import com.example.progresstracker.R
import com.example.progresstracker.models.PeopleItem
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.bottom_sheet_more_people.*
import kotlinx.android.synthetic.main.bottom_sheet_more_people.view.*

class BottomSheetMorePeople(private val context: Context,
                            private val items: List<PeopleItem>) {

    val wrappedContext = ContextThemeWrapper(context, R.style.transparentbg)
    private val bottomSheetDialog: BottomSheetDialog = BottomSheetDialog(wrappedContext)

    init {
        val view = LayoutInflater.from(context).inflate(R.layout.bottom_sheet_more_people, null)
        bottomSheetDialog.setContentView(view)



        with(view) {
            (this?.parent as ViewGroup).setBackgroundColor(Color.TRANSPARENT)
            recyclerview_bottom_sheet_more_people.layoutManager = GridLayoutManager(context, 3)
            recyclerview_bottom_sheet_more_people.adapter = BottomSheetAdapter(items)
        }
    }

    fun show() {


        bottomSheetDialog.show()
    }


}



















//
//class BottomSheetMorePeople : BottomSheetDialogFragment() {
//    private lateinit var peopleAdapter: BottomSheetAdapter
//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        initRecyclerView()
//        sendData()
//        return inflater.inflate(R.layout.bottom_sheet_more_people, container, false)
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//    }
//
//    private fun sendData(){
//        val data = DataSourcePeopleList.createDataSet()
//        peopleAdapter.submitList(data)
//    }
//
//    private fun initRecyclerView() {
////        recyclerview_bottom_sheet_more_people.apply {
////            //layoutManager = LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL, false)
////            peopleAdapter = BottomSheetAdapter()
////            adapter = peopleAdapter
////        }
//    }
//}