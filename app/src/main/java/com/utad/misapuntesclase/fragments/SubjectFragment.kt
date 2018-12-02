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
import com.utad.misapuntesclase.adapters.SubjectAdapter
import com.utad.misapuntesclase.modelsEntity.RecyclerViewData
import com.utad.misapuntesclase.modelsEntity.Subject
import org.jetbrains.anko.doAsync


class SubjectFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    var items: ArrayList<Subject> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the grade_rv_item for this fragment
        return inflater.inflate(R.layout.fragment_subject, container, false).apply {
            //Here is the things you need for a RecylcerView to work
            viewManager = GridLayoutManager(activity, 2)
            viewAdapter = SubjectAdapter(items)
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
            var recyclerViewDataArrayList: ArrayList<RecyclerViewData> = ArrayList()
            recyclerViewDataArrayList.add(RecyclerViewData("13", "Number of Alumns"))
            recyclerViewDataArrayList.add(RecyclerViewData("Random teacher", "Teacher"))
            recyclerViewDataArrayList.add(RecyclerViewData("7", "Total average grade"))
            recyclerViewDataArrayList.add(RecyclerViewData("9.9", "My average grade"))
            recyclerViewDataArrayList.add(RecyclerViewData("3", "Ranking"))

            items.add(Subject(R.drawable.ic_, "Services And Processes Programming", "Processes and threats", recyclerViewDataArrayList))
            items.add(Subject(R.drawable.ic_interfaces, "Interfaces", "You are suppose to learn interfaces here but we do Android",recyclerViewDataArrayList))
            items.add(Subject(R.drawable.ic_data_access, "Database Access", "Yo will die here", recyclerViewDataArrayList))
            items.add(Subject(R.drawable.ic_mobile_development, "Mobile Programming", "We learn iOs here", recyclerViewDataArrayList))
            items.add(Subject(R.drawable.ic_sgem, "Enterprise Administration Systems", "I don't know what is this about", recyclerViewDataArrayList))
            items.add(Subject(R.drawable.ic_english, "English", "Technical English for programmers", recyclerViewDataArrayList))
            items.add(Subject(R.drawable.ic_work_center, "Work Center Formation", "Formation in a external center", recyclerViewDataArrayList))
            items.add(Subject(R.drawable.ic_idea, "Final Project", "Final work where you demonstrate what you learn",recyclerViewDataArrayList ))
        }
    }


}
