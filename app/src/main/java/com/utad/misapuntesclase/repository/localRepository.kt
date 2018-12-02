package com.utad.misapuntesclase.repository

import android.app.Application
import android.arch.lifecycle.LiveData
import com.utad.misapuntesclase.dao.ClassroomDAO
import com.utad.misapuntesclase.db.AppDatabase
import javax.security.auth.Subject

class localRepository {

//    private var mClassroomDAO: ClassroomDAO? = null
//    private var mClassroom: LiveData<List<Subject>>? = null
//
//    companion object {
//        @Volatile
//        private var INSTANCE: localRepository? = null
//
//        fun getInstance(context: Application): localRepository =
//            INSTANCE ?: synchronized(this) {
//                INSTANCE ?: localRepository(context).also { INSTANCE = it }
//            }
//    }
//
//    init {
//        AppDatabase.getInstance(application).also {
//            mStudentDao = it.studentsDao()
//            mStudents = mClassroomDAO?.getAll()
//        }
//    }
//
//    fun getAllStudents(): LiveData<List<Subject>>? {
//        return mStudents
//    }

}