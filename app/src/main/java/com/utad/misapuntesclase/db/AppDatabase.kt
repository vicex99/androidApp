package com.utad.misapuntesclase.db

import android.app.Application
import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.*
import android.os.AsyncTask
import com.utad.misapuntesclase.BuildConfig
import com.utad.misapuntesclase.dao.*
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
abstract class AppDatabase: RoomDatabase() {

    abstract fun ClassroomDao(): ClassroomDAO
    abstract fun CommunityDAO(): CommunityDAO
    abstract fun GradesDAO(): GradesDAO
    abstract fun NotificationDAO(): NotificationDAO
    abstract fun TeacherDAO(): TeacherDAO

    //TODO: do late
    abstract fun UserDAO(): UserDAO


    companion object {
        // Get DB name from constant configuration
        private val DB_NAME = BuildConfig.DATABASE_NAME
        @Volatile private var INSTANCE: AppDatabase? = null

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
                            this.insert(defClassroomData)
                        }

                        database.CommunityDAO().run {
                            this.deleteAll()
                            this.insert(defCommunityData)
                        }

                        database.NotificationDAO().run {
                            this.deleteAll()
                            this.insert(defNotificationData)
                        }
                        database.GradesDAO().run {
                            this.deleteAll()
                            this.insert(defGradesData)
                        }

                        database.TeacherDAO().run {
                            this.deleteAll()
                            this.insert(defTeacherData)
                        }
                    }
                }

            }
        }

       //todo: implement

    }
}
