package com.example.progresstracker.admin.project

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.progresstracker.R
import com.example.progresstracker.models.ProjectItem
import com.google.android.material.card.MaterialCardView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.project_row.view.*


class ProjectItemAdapter(private val listener: OnItemClickListener) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var items: List<ProjectItem> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ProjectViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.project_row, parent, false)
        )
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val item: ProjectItem = items[position]
        ViewCompat.setTransitionName(holder.itemView.project_admin_cardView, item.name)
        holder.itemView.setOnClickListener{ listener.onItemClick(holder.adapterPosition, items[position], holder.itemView.project_admin_cardView) }

        when (holder) {
            is ProjectViewHolder -> {
                holder.bind(items[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun submitList(projectList: List<ProjectItem>) {
        items = projectList
    }


    inner class ProjectViewHolder constructor(
            itemView: View) : RecyclerView.ViewHolder(itemView),
            View.OnClickListener {

        val project_name = itemView.textview_project_name
        val project_priority = itemView.textview_project_priority
        val project_percent = itemView.textview_project_devs
        val project_people_number = itemView.textview_project_description

        fun bind(projectItem: ProjectItem) {
            project_name.text = projectItem.name
            project_priority.text = projectItem.priority
            project_percent.text = projectItem.percent
            project_people_number.text = projectItem.numberPeople
            itemView.project_admin_cardView.transitionName = projectItem.name


        }

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {

        }
//
//        override fun onClick(v: View?) {
//            val position = adapterPosition
//            if(position != RecyclerView.NO_POSITION) {
//                listener.onItemClick(position, items[position])
//            }
//        }


    }



    interface OnItemClickListener {
        fun onItemClick(position: Int, item: ProjectItem, sharedCardView: CardView)
    }
}