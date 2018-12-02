package com.utad.misapuntesclase.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import com.utad.misapuntesclase.modelsEntity.Grades

@Dao
interface GradesDAO {
    //TODO("changeData")
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(classData: Grades): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(classData: List<Grades>): LongArray


    @Update
    fun update(classData: Grades): Int


    @Query("DELETE FROM Subject")
    fun deleteAll()

    @Query("SELECT * from grades ORDER BY subject ASC")
    fun getAllClass(): LiveData<List<Grades>>

}