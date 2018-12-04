package com.utad.misapuntesclase.repository

import android.app.Application
import android.arch.lifecycle.LiveData
import com.utad.misapuntesclase.dao.*
import com.utad.misapuntesclase.db.AppDatabase
import com.utad.misapuntesclase.modelsEntity.*

class BDRepository private constructor(application: Application) {

    private var mClassroomDAO: ClassroomDAO
    private var mClassroom: LiveData<List<Subject>>? = null

    private var mCommunityDAO: CommunityDAO
    private var mCommunity: LiveData<List<Community>>? = null

    private var mGradesDAO: GradesDAO
    private var mGrades: LiveData<List<Grades>>? = null

    private var mNotificationDAO: NotificationDAO
    private var mNotification: LiveData<List<Notifications>>? = null

    private var mTeacherDAO: TeacherDAO
    private var mTeacher: LiveData<List<Teacher>>? = null


    companion object {
        @Volatile
        private var INSTANCE: BDRepository? = null

        fun getInstance(context: Application): BDRepository =
            INSTANCE ?: synchronized(this) {
                INSTANCE
                    ?: BDRepository(context).also { INSTANCE = it }
            }
    }

    init {
        AppDatabase.getInstance(application).also {
            mClassroomDAO = it.ClassroomDao()
            mClassroom = mClassroomDAO.getAll()

            mCommunityDAO = it.CommunityDAO()
            mCommunity = mCommunityDAO.getAll()

            mGradesDAO = it.GradesDAO()
            mGrades = mGradesDAO.getAll()

            mNotificationDAO = it.NotificationDAO()
            mNotification = mNotificationDAO.getAll()

            mTeacherDAO = it.TeacherDAO()
            mTeacher = mTeacherDAO.getAll()
        }
    }

    fun getAllClassrooms(): LiveData<List<Subject>>? {
        return mClassroom
    }
    fun getAllCommunities(): LiveData<List<Community>>? {
        return mCommunity
    }
    fun getAllGrades(): LiveData<List<Grades>>? {
        return mGrades
    }
    fun getAllNotifications(): LiveData<List<Notifications>>? {
        return mNotification
    }
    fun getAllTeachers(): LiveData<List<Teacher>>? {
        return mTeacher
    }
}