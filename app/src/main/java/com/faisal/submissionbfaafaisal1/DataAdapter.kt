package com.faisal.submissionbfaafaisal1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView



class DataAdapter internal constructor(private val context: Context) : BaseAdapter() {
    internal var data = arrayListOf<Data>()

    override fun getCount(): Int = data.size

    override fun getItem(p0: Int): Any = data[p0]

    override fun getItemId(p0: Int): Long = p0.toLong()

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var itemView = p1
        if (itemView == null){
            itemView = LayoutInflater.from(context).inflate(R.layout.item,p2,false)
        }

        val viewHolder = ViewHolder(itemView as View)
        val data = getItem(p0) as Data
        viewHolder.bind(data)
        return itemView
    }

    private inner class ViewHolder internal constructor(view: View){
        var txtLocation : TextView = view.findViewById(R.id.txt_location)
        var imgPhoto : ImageView = view.findViewById(R.id.img_photo)
        var txtName : TextView = view.findViewById(R.id.txt_name)

         fun bind(data: Data){
            txtLocation.text = data.location
            txtName.text = data.name
            imgPhoto.setImageResource(data.avatar)
        }
    }

}