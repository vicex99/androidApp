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
import com.utad.misapuntesclase.modelsEntity.Community
import com.utad.misapuntesclase.repository.BDRepository
import org.jetbrains.anko.doAsync


class CommunitiesFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    var items: ArrayList<Community> = ArrayList()

    private lateinit var mRepo: BDRepository

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Set repository
        mRepo = BDRepository.getInstance()

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

            mRepo.getAllCommunities()
        }
    }
}