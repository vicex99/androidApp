package com.utad.misapuntesclase.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import com.utad.misapuntesclase.modelsEntity.Teacher

@Dao
interface TeacherDAO {

    //TODO("changeData")
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(classData: Teacher): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(classData: List<Teacher>): LongArray


    @Query("SELECT * from Teacher ORDER BY name ASC")
    fun getAll(): LiveData<List<Teacher>>


    @Update
    fun update(classData: Teacher): Int

    @Query("DELETE FROM Teacher")
    fun deleteAll()

}