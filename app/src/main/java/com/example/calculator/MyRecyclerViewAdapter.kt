package com.example.calculator

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class MyRecyclerViewAdapter(private val list :List<LastExpression>)
    : RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       //inflate
    // that is used to hold list item
   val view= LayoutInflater.from(parent.context).inflate(R.layout.list_item_design,parent,false)
        val viewHolder=MyViewHolder(view)
        return viewHolder
//        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
    val lastExpression=list.get(position)
        holder.textView.text=lastExpression.result
    }

    override fun getItemCount(): Int {
        return list.size
    }

    // Holds the views for adding it to  text
    class MyViewHolder( itemView: View) : RecyclerView.ViewHolder(itemView){
        val textView:TextView=itemView.findViewById(R.id.list_item_design_textView)
    }
}