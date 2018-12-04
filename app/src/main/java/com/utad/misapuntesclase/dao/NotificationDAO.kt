package com.utad.misapuntesclase.dao

import android.app.Notification
import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import com.utad.misapuntesclase.modelsEntity.Notifications

@Dao
interface NotificationDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(classData: Notifications): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(classData: List<Notifications>): LongArray

    // para que salgan los ultimos antes se pone "DESC"
    @Query("SELECT * from Notifications ORDER BY date DESC")
    fun getAll(): LiveData<List<Notifications>>


    @Update
    fun update(classData: Notifications): Int

    @Query("DELETE FROM Notifications")
    fun deleteAll()

}