package com.demo.pagingdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.entity_view.view.*

class EntityAdapter() : PagedListAdapter<Entity, EntityAdapter.EntityViewHolder>(DIFF_CALLBACK) {

    override fun onBindViewHolder(holder: EntityAdapter.EntityViewHolder, position: Int) {

        holder.name.text = getItem(position)?.name;
        holder.description.text = getItem(position)?.description;
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EntityViewHolder {
        return EntityAdapter.EntityViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.entity_view,
                parent,
                false
            )
        )
    }

    class EntityViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var name = view.name;
        var description = view.description;
    }

    companion object {

        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Entity>() {
            override fun areItemsTheSame(oldItem: Entity, newItem: Entity): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(oldItem: Entity, newItem: Entity): Boolean {
                return oldItem.name == newItem.name
            }
        }
    }
}