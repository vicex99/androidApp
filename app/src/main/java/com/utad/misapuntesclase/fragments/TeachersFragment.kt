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
import com.utad.misapuntesclase.adapters.TeacherAdapter
import io.github.alvarosanzrodrigo.fragmentlisttask3.Models.RecyclerViewData
import io.github.alvarosanzrodrigo.fragmentlisttask3.Models.Teacher
import org.jetbrains.anko.doAsync


class TeachersFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    var items: ArrayList<Teacher> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the grade_rv_item for this fragment
        return inflater.inflate(R.layout.fragment_subject, container, false).apply {
            //Here is the things you need for a RecylcerView to work
            viewManager = GridLayoutManager(activity, 2)
            viewAdapter = TeacherAdapter(items)
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

    private fun populateSubjects(){
        //I'm using Anko to do asynk tasks
        doAsync {

            var recyclerViewDataArrayList: ArrayList<RecyclerViewData> = ArrayList()
            recyclerViewDataArrayList.add(RecyclerViewData("asignatura 1", "3 horas"))
            recyclerViewDataArrayList.add(RecyclerViewData("asignatura 2", "2 horas"))
            recyclerViewDataArrayList.add(RecyclerViewData("asignatura 4", "5 horas"))
            items.add(Teacher(R.mipmap.profile_pic_teacher_1_round, "David", "Jardon Peinado", recyclerViewDataArrayList))
            items.add(Teacher(R.mipmap.profile_pic_teacher_2_round, "Pedro", "Camacho", recyclerViewDataArrayList))
            items.add(Teacher(R.mipmap.profile_pic_teacher_4_round, "Jaime", "Lannister", recyclerViewDataArrayList))
            items.add(Teacher(R.mipmap.profile_pic_teacher_5_round, "Carlos", "El de iOs", recyclerViewDataArrayList))
            items.add(Teacher(R.mipmap.profile_pic_teacher_6_round, "Laura", "Nose", recyclerViewDataArrayList))
            items.add(Teacher(R.mipmap.profile_pic_teacher_7_round, "Meritxel", "La de fol", recyclerViewDataArrayList))
        }
    }
}