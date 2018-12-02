package com.utad.misapuntesclase.dao

import android.app.Notification
import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import com.utad.misapuntesclase.modelsEntity.Notifications

@Dao
interface NotificationDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOne(classData: Notifications): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(classData: List<Notifications>): LongArray


    @Update
    fun update(classData: Notification): Int


    @Query("DELETE FROM Notifications")
    fun deleteAll()

    // para que salgan los ultimos antes se pone "DESC"
    @Query("SELECT * from Notifications ORDER BY date DESC")
    fun getAllClass(): LiveData<List<Notification>>

}