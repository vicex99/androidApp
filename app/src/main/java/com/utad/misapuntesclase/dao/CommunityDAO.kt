package com.utad.misapuntesclase.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import com.utad.misapuntesclase.modelsEntity.Community

@Dao
interface CommunityDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(classData: Community): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(classData: List<Community>): LongArray

    @Query("SELECT * from community ORDER BY name ASC")
    fun getAll(): LiveData<List<Community>>

    @Update
    fun update(classData: Community): Int


    @Query("DELETE FROM community")
    fun deleteAll()

}