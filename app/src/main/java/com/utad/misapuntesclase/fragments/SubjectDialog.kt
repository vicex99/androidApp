package com.utad.misapuntesclase.fragments

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.content.ContextCompat
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.utad.misapuntesclase.R
import com.utad.misapuntesclase.adapters.DialogAdapter
import com.utad.misapuntesclase.modelsEntity.RecyclerViewData

class SubjectDialog : DialogFragment() {
    companion object {
        const val NAME = "1"
        const val BELOW_NAME = "2"
        const val IMAGE = "5"
        const val RECYCLERVIEW_DATA = "3"
        const val DESCRIPTION = "4"
    }

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    private var items: ArrayList<RecyclerViewData> = ArrayList()

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        items = arguments?.get(RECYCLERVIEW_DATA) as ArrayList<RecyclerViewData>
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {




        return inflater.inflate(R.layout.fragment_subject_dialog, container, false).apply {


            //Here is the things you need for a RecylcerView to work
                        viewManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            viewAdapter = DialogAdapter(items)
            recyclerView = this.findViewById<RecyclerView>(R.id.dialog_fragment_rv).apply {
                setHasFixedSize(true)
                layoutManager = viewManager
                adapter = viewAdapter
            }
            //I added the listener for the floating button
            val fab: View = findViewById(R.id.fab)
            fab.setOnClickListener { view ->
                val phone = "+34666777888"
                val intent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null))
                startActivity(intent)
            }
            //Set the view data
            arguments?.get(NAME).let {
                findViewById<TextView>(R.id.dialogName).text = it as String
            }
            arguments?.get(BELOW_NAME).let {
                findViewById<TextView>(R.id.dialogsubtitle).text = it as String
            }
            arguments?.get(DESCRIPTION).let {
                findViewById<TextView>(R.id.dialog_description).text = it as String
            }
            arguments?.get(IMAGE).let { int ->
                findViewById<ImageView>(R.id.dialog_image).setImageDrawable(context?.let {
                    ContextCompat.getDrawable(
                        it , int as Int
                    )
                })
            }

            arguments?.get(DESCRIPTION).let {
                findViewById<TextView>(R.id.dialog_description).text = it as String
            }

        }
    }
}
