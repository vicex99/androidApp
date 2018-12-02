package com.utad.misapuntesclase.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.utad.misapuntesclase.R
import com.utad.misapuntesclase.modelsEntity.Teacher


class TeacherAdapter(var items: ArrayList<Teacher>) : RecyclerView.Adapter<TeacherAdapter.MyViewHolder>() {
    var mCallBack: OnClickedItemListener? = null
    var contextToSend: Context? = null

    class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view)
    //Interface! i's used when you click on a item
    interface OnClickedItemListener {
        fun onItemSelected(teacher: Teacher)
    }

    // Create new views (invoked by the grade_rv_item manager)
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): MyViewHolder {
        // create a new view
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.subject_item, parent, false).apply {
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
        holder.view.findViewById<TextView>(R.id.subject_item_textView).apply {
            text = items[position].name
            isSelected = true
        }
        holder.view.findViewById<ImageView>(R.id.subject_item_imageView).setImageResource(items[position].imageID)
    }

    // Return the size of your dataset (invoked by the grade_rv_item manager)
    override fun getItemCount() = items.size
}