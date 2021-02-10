package com.example.progresstracker.admin.projectDetails

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.progresstracker.R
import com.example.progresstracker.models.FeatureItem

import kotlinx.android.synthetic.main.feature_row_admin.view.*


class FeatureItemAdapter(private val context:Context,private val onItemClickListener: OnItemClickListener) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    private var items : List<FeatureItem> = ArrayList()
    private lateinit var mContext:Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        this.mContext=context
        return FeatureViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.feature_row_admin,parent,false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when(holder){
            is FeatureViewHolder ->{
                holder.bind(items.get(position))
                var isExpanded:Boolean = items.get(position).expanded
                if(isExpanded)
                {
                    holder.expandable_layout.visibility=View.VISIBLE
                    holder.itemView.textview_more_people.setOnClickListener {
                        Log.d("stuff","this works")
                        if(mContext is Project_details_admin)
                        {
                          (mContext as Project_details_admin).showMenu()
                        }
                        onItemClickListener.onClick(position)
                      // Toast.makeText(holder.expandable_layout.context,"Just have to find a way to show bottom sheet",Toast.LENGTH_SHORT)
                    }

                }
                else
                {
                    holder.expandable_layout.visibility=View.GONE
                }
            }
        }
    }
    override fun getItemCount(): Int {
        return items.size
    }
    class ViewHolder(itemView: View,onItemClickListener: OnItemClickListener): RecyclerView.ViewHolder(itemView){
        init {
            itemView.textview_more_people.setOnClickListener{
                Log.d("stuff","this works 2")
                onItemClickListener.onClick(adapterPosition)
            }
        }
    }
    fun submitList(featureList: List<FeatureItem>){
        items = featureList
    }
    fun setListener(){

    }


    inner class FeatureViewHolder constructor(
        itemView : View): RecyclerView.ViewHolder(itemView)
        {

        val cardview=itemView.cardview_feature
        val feature_name = itemView.textview_feature_name
        val feature_priority = itemView.textview_feature_priority
        val feature_percent = itemView.textview_feature_percent
        val feature_people_number = itemView.textview_feature_devs
        val feature_description = itemView.textview_feature_description
        val expandable_layout = itemView.expandableLayout


        fun bind(featureItem: FeatureItem){
            cardview.setOnClickListener{

                if(featureItem.expanded == false)
                {
                    featureItem.expanded =true
                    notifyItemChanged(adapterPosition)
                }
                else{
                    featureItem.expanded = false
                    notifyItemChanged(adapterPosition)
                }
            }
            feature_name.setText(featureItem.name)
            feature_priority.setText(featureItem.priority)
            feature_percent.setText(featureItem.percent)
            feature_people_number.setText(featureItem.numberPeople)
            feature_description.setText(featureItem.description)
            //val requestOptions = RequestOptions()


        }




    }

    interface OnItemClickListener{
        fun onClick(position: Int){
            Log.d("stuff","this works too at $position")
        }
    }


}