package com.shogo.simplerecyclerview

import android.app.Activity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

fun <T> RecyclerView.initSimpleRecyclerView(ctx: Activity, items: List<T>, layout: Int, binder: View.(T) -> Unit) {
    layoutManager = LinearLayoutManager(ctx)
    adapter = SimpleAdapter(items,layout,binder)
}

class SimpleAdapter<T>(val items: List<T>, val row_layout: Int, val binder: View.(T) -> Unit): RecyclerView.Adapter<SimpleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpleViewHolder {
        val row = LayoutInflater.from(parent.context).inflate(row_layout,parent,false)
        return SimpleViewHolder(row)
    }

    override fun onBindViewHolder(holder: SimpleViewHolder, position: Int) {
        holder.view.binder(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

}

class SimpleViewHolder(val view: View): RecyclerView.ViewHolder(view)
