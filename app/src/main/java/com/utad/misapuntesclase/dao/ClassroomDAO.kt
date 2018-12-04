package com.utad.misapuntesclase.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import com.utad.misapuntesclase.modelsEntity.Subject

@Dao
interface ClassroomDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(classData: Subject): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(classData: List<Subject>): LongArray


    @Query("SELECT * from Subject ORDER BY name ASC")
    fun getAll(): LiveData<List<Subject>>


    @Update
    fun update(classData: Subject): Int


    @Query("DELETE FROM Subject")
    fun deleteAll()

}