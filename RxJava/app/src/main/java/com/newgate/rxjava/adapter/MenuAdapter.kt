package com.newgate.rxjava.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.newgate.rxjava.models.Menu

/**
 * Created by khiemnd on 7/31/17.
 */
class MenuAdapter(var context: Context, var arrayMenu: ArrayList<Menu>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {

    }

    override fun getItemCount(): Int {
        return arrayMenu.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {

    }

    class MenuViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        
    }
}