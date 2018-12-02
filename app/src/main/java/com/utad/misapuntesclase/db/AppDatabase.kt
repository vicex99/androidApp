package com.utad.misapuntesclase.db

import android.app.Application
import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.db.SupportSQLiteOpenHelper
import android.arch.persistence.room.*
import com.utad.misapuntesclase.BuildConfig
import com.utad.misapuntesclase.modelsEntity.*
import org.jetbrains.anko.doAsync
import java.util.*
import javax.security.auth.Subject

@Database(entities = [Subject::class,
                    Community::class,
                    Grades::class,
                    Notifications::class,
                    Teacher::class,
                    UserData::class
                    ],
            version = 1)
class AppDatabase: RoomDatabase() {
    companion object {
        // Get DB name from constant configuration
        private val DB_NAME = BuildConfig.DATABASE_NAME
        @Volatile private var INSTANCE: AppDatabase? = null
    }
    // config Instance
    fun getInstance(context: Application): AppDatabase =
        INSTANCE ?: synchronized(this) {
            INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
        }

    fun destroyInstance() {
        INSTANCE = null
    }

    // Build database and initialize
    private fun buildDatabase(context: Application) =
    // ONLY FOR TEST. Change to databaseBuilder()
        Room.databaseBuilder(context, AppDatabase::class.java, DB_NAME)
            // Wipes and rebuilds instead of migrating
            // if no Migration object.
            .fallbackToDestructiveMigration()
            .addCallback(sRoomDatabaseCallback)
            .build()

    private val sRoomDatabaseCallback = object : RoomDatabase.Callback() {
        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)

            // Create AsyncTask to do work in background
            //PopulateDbAsync(INSTANCE).execute()


            // Use Anko library to do work in background
            INSTANCE?.let { database ->
                doAsync {
                    database.ClassroomDao().run {
                        this.deleteAll()
                        this.insert(subjects)
                    }

                    database.CommunityDAO().run {
                        this.deleteAll()
                        this.insert(communities)
                    }

                    database.NotificationDAO().run {
                        this.deleteAll()
                        this.insert(notifications)
                    }

                    database.GradesDAO.run {
                        this.deleteAll()
                        this.insert(scores)
                    }

                    database.TeacherDAO().run {
                        this.deleteAll()
                        this.insert(studens)
                    }
                }
            }

        }
    }

}