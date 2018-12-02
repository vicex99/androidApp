package com.utad.misapuntesclase.modelsEntity

import java.util.*
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "Grades")
class Grades(var grade: String, var date: Date, var subject: String, var task: String) {
    @PrimaryKey(autoGenerate = false)
    var id: Int? = null
}