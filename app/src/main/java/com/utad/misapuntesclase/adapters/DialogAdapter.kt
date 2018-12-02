package com.utad.misapuntesclase.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.utad.misapuntesclase.R
import io.github.alvarosanzrodrigo.fragmentlisttask3.Models.RecyclerViewData

class DialogAdapter(var items: ArrayList<RecyclerViewData>) : RecyclerView.Adapter<DialogAdapter.MyViewHolder>() {

    var contextToSend: Context? = null

    class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view)
    //Interface! i's used when you click on a item


    // Create new views (invoked by the grade_rv_item manager)
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): MyViewHolder {
        // create a new view
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.dialog_rv_item, parent, false).apply {
            //You asign the callback to the parent

            contextToSend = context
        } as View

        return MyViewHolder(view)
    }

    // Replace the contents of a view (invoked by the grade_rv_item manager)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.view.findViewById<TextView>(R.id.dialog_rv_item_name).apply {
            text = items[position].name
            isSelected = true
        }
        holder.view.findViewById<TextView>(R.id.dialog_rv_item_data).apply {
            text = items[position].data
            isSelected = true
        }
    }

    // Return the size of your dataset (invoked by the grade_rv_item manager)
    override fun getItemCount() = items.size
}