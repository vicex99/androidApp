package com.utad.misapuntesclase.adapters


import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.utad.misapuntesclase.R
import io.github.alvarosanzrodrigo.fragmentlisttask3.Models.Notifications
import java.util.*


class NotificationsAdapter(var items: ArrayList<Notifications>) : RecyclerView.Adapter<NotificationsAdapter.MyViewHolder>() {
    var mCallBack: OnClickedItemListener? = null
    var contextToSend: Context? = null

    class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view)
    //Interface! i's used when you click on a item
    interface OnClickedItemListener {
        fun onItemSelected(notifications: Notifications)
    }

    // Create new views (invoked by the grade_rv_item manager)
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): MyViewHolder {
        // create a new view
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.notifications_rv_item, parent, false).apply {
            //You asign the callback to the parent
            mCallBack = parent.context as OnClickedItemListener
            contextToSend = context
        } as View

        return MyViewHolder(view)
    }

    // Replace the contents of a view (invoked by the grade_rv_item manager)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.itemView.setOnClickListener {
            mCallBack?.onItemSelected(items[position])
        }
        holder.view.findViewById<TextView>(R.id.notifications_rv_date).apply {
            text = """${items[position].date.hours.toString()}:${items[position].date.minutes.toString()}"""
            isSelected = true
        }
        holder.view.findViewById<TextView>(R.id.notifications_rv_username).apply {
            text = items[position].username
            isSelected = true
        }
        holder.view.findViewById<TextView>(R.id.notifications_rv_title).apply {
            text = items[position].title
            isSelected = true
        }
        
    }

    // Return the size of your dataset (invoked by the grade_rv_item manager)
    override fun getItemCount() = items.size
}