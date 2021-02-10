package com.example.progresstracker.admin.projectDetails

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.progresstracker.R
import com.example.progresstracker.models.PeopleItem
import kotlinx.android.synthetic.main.person_bottom_sheet.view.*

class BottomSheetAdapter(private val items: List<PeopleItem>) : RecyclerView.Adapter<BottomSheetAdapter.BottomSheetMenuViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BottomSheetMenuViewHolder {
        return BottomSheetMenuViewHolder(LayoutInflater.from(parent!!.context).inflate(R.layout.person_bottom_sheet, parent, false))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: BottomSheetMenuViewHolder, position: Int) {
        holder.bind(items[position])
    }

    class BottomSheetMenuViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        fun bind(item: PeopleItem) {
            with(view) {
                bottom_sheet_dev_name.text = item.name
                bottom_sheet_dev_image.setImageResource(item.imgID)

            }
        }
    }



}










//
//internal class BottomSheetAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
//    private var items : List<PeopleItem> = ArrayList()
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
//        return PeopleViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.person_bottom_sheet, parent, false))
//    }
//    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
//        when(holder){
//            is PeopleViewHolder ->{
//                holder.bind(items[position])
//            }
//        }
//    }
//
//    override fun getItemCount(): Int {
//        return items.size
//    }
//    fun submitList(peopleList: List<PeopleItem>){
//        items = peopleList
//    }
//    inner class PeopleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
//
//        var title: TextView
//
//
//        fun bind(peopleItem: PeopleItem){
//            title.text = peopleItem.name
//        }
//
//        init {
//
//            title = itemView.findViewById(R.id.title)
//
//        }
//
//        fun onBindData(url: String) {
//
//        }
//        override fun onClick(v: View?) {
//
//        }
//
//
//    }
//
//
//
//
//}