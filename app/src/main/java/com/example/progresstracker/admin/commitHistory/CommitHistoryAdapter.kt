package com.example.progresstracker.admin.commitHistory

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.progresstracker.R
import com.example.progresstracker.admin.project.ProjectItemAdapter
import com.example.progresstracker.models.CommitItem
import com.example.progresstracker.models.ProjectItem
import kotlinx.android.synthetic.main.commit_row_admin.view.*
import kotlinx.android.synthetic.main.project_row.view.*

class CommitHistoryAdapter(private val listener: OnItemClickListener) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var items : List<CommitItem> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return CommitViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.commit_row_admin,parent,false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is CommitViewHolder ->{
                holder.bind(items[position])
            }
        }
    }
    override fun getItemCount(): Int {
        return items.size
    }
    fun submitList(commitList: List<CommitItem>){
        items = commitList
    }


    inner class CommitViewHolder constructor(
        itemView : View): RecyclerView.ViewHolder(itemView),
        View.OnClickListener{
        val project_name = itemView.textview_commit_project_name
        val commit_time = itemView.textview_commit_time
        val commit_message = itemView.textview_commit_message

        fun bind(commitItem: CommitItem){
            project_name.text = commitItem.projectName
            commit_time.text = commitItem.commitTime
            commit_message.text = commitItem.commitMessage


        }
        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if(position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }
    }
    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }
}