package com.utad.misapuntesclase.fragments

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.utad.misapuntesclase.R
import com.utad.misapuntesclase.adapters.CommunityAdapter
import io.github.alvarosanzrodrigo.fragmentlisttask3.Models.Community
import io.github.alvarosanzrodrigo.fragmentlisttask3.Models.RecyclerViewData
import org.jetbrains.anko.doAsync


class CommunitiesFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    var items: ArrayList<Community> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the grade_rv_item for this fragment
        return inflater.inflate(R.layout.fragment_subject, container, false).apply {
            //Here is the things you need for a RecylcerView to work
            viewManager = GridLayoutManager(activity, 2)
            viewAdapter = CommunityAdapter(items)
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
//To populate the example data
    private fun populateSubjects(){
        //I'm using Anko to do asynk tasks
        doAsync {

            var recyclerViewDataArrayList: ArrayList<RecyclerViewData> = ArrayList()
            recyclerViewDataArrayList.add(RecyclerViewData("23", "Number of alums"))
            recyclerViewDataArrayList.add(RecyclerViewData("M107", "Classroom"))
            recyclerViewDataArrayList.add(RecyclerViewData("Contest 1", "Eventos"))
            recyclerViewDataArrayList.add(RecyclerViewData("U-tad Manager", "Current Project"))
            recyclerViewDataArrayList.add(RecyclerViewData("9.9", "Rating"))
            items.add(Community("Programming",
                R.drawable.ic_interfaces, "A community for programming in general, what ever you want to learn you can do it here.", "Daniel The Tall One", recyclerViewDataArrayList))
            items.add(Community("Mobile",
                R.drawable.ic_mobile_development, "A community for Android and iOs, what ever you want to learn you can do it here.", "Daniel The Tall One", recyclerViewDataArrayList))
            items.add(Community("Virtual Reality",
                R.drawable.ic_virtual_reality, "A community for virtual reality programming , what ever you want to learn you can do it here.", "Daniel The Tall One", recyclerViewDataArrayList))
            items.add(Community("Videogames",
                R.drawable.ic_videogames, "A community for programming videogames, and games discussing, what ever you want to learn you can do it here.", "Daniel The Tall One", recyclerViewDataArrayList))
        }
    }
}