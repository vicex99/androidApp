package com.utad.misapuntesclase.fragments

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.utad.misapuntesclase.R
import com.utad.misapuntesclase.adapters.NotificationsAdapter
import io.github.alvarosanzrodrigo.fragmentlisttask3.Models.Notifications
import org.jetbrains.anko.doAsync
import java.util.*


class NotificationsFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    var items: ArrayList<Notifications> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the grade_rv_item for this fragment
        return inflater.inflate(R.layout.fragment_subject, container, false).apply {
            //Here is the things you need for a RecylcerView to work
            viewManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            viewAdapter = NotificationsAdapter(items)
            recyclerView = this.findViewById<RecyclerView>(R.id.rv_documents).apply {
                setHasFixedSize(true)
                layoutManager = viewManager
                adapter = viewAdapter
            }
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        populateSubjects()
    }
    // this populate the subjects programmatically, they dont need to change for the moment
    private fun populateSubjects(){
        //I'm using Anko to do asynk tasks
        doAsync {
            items.add(Notifications("Pepe", Date(), "PSPR"))
            items.add(Notifications("Juan", Date(), "DINT"))
            items.add(Notifications("Alvaro", Date(), "Prog"))

        }
    }


}
