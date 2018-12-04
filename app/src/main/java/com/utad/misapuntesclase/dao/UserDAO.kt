package com.utad.misapuntesclase.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import com.utad.misapuntesclase.modelsEntity.UserData

@Dao
interface UserDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(classData: UserData): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(classData: List<UserData>): List<Long>

    // TODO: set data when finnish the register
    @Query("SELECT * from user")
    fun getAll(): LiveData<UserData>

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(classData: UserData): Int

    //TODO: clear data with logout
    @Query("DELETE FROM user")
    fun deleteAll()

}