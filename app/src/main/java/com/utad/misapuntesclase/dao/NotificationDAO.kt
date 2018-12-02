package com.utad.misapuntesclase.dao

import android.app.Notification
import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*

@Dao
interface NotificationDAO {
    //TODO("changeData")
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(classData: Notification): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(classData: List<Notification>): LongArray


    @Update
    fun update(classData: Notification): Int


    @Query("DELETE FROM Notifications")
    fun deleteAll()

    // para que salgan los ultimos antes se pone "DESC"
    @Query("SELECT * from Notifications ORDER BY date DESC")
    fun getAllClass(): LiveData<List<Notification>>

}