package com.example.fooddeliveryapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter(context: Context?) : RecyclerView.Adapter<ItemAdapter.ViewHolder>(){
    var dataList = emptyList<Data>()

    internal fun setDataList(dataList: List<Data>) {
        this.dataList = dataList
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image: ImageView
        var title: TextView
        var desc: TextView
        var btnAdd: ImageButton

        init {
            image = itemView.findViewById(R.id.image)
            title = itemView.findViewById(R.id.title)
            desc = itemView.findViewById(R.id.desc)
            btnAdd = itemView.findViewById(R.id.btn_add_to_cart)


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAdapter.ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.list_of_items, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemAdapter.ViewHolder, position: Int) {
        var info = dataList[position]

        holder.title.text = info.Title
        holder.desc.text = info.Description

        holder.image.setImageResource(info.image)
        holder.btnAdd.setOnClickListener {
            singletonCart.addProduct(info)
        }
    }

    override fun getItemCount() = dataList.size
    }

