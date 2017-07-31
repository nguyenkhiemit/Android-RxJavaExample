package com.newgate.rxjava.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.newgate.rxjava.R
import com.newgate.rxjava.models.Menu
import kotlinx.android.synthetic.main.layout_item_menu.view.*

/**
 * Created by khiemnd on 7/31/17.
 */
class MenuAdapter(var context: Context, var arrayMenu: ArrayList<Menu>, var itemClick: (Int) -> Unit): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemCount(): Int {
        return arrayMenu.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.layout_item_menu, parent, false)
        return MenuViewHolder(view, itemClick)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        var menu = arrayMenu[position]
        if(holder is MenuViewHolder) {
            holder.bindData(menu)
        }
    }

    class MenuViewHolder(itemView: View, var itemClick: (Int) -> Unit): RecyclerView.ViewHolder(itemView) {
         fun bindData(menu: Menu) {
             itemView.titleText.text = menu.title
             itemView.setOnClickListener {
                 itemClick(menu.index)
             }
         }
    }
}