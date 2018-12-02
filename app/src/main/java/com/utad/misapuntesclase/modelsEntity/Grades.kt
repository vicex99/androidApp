package com.utad.misapuntesclase.modelsEntity

import java.util.*
import android.arch.persistence.room.Entity

@Entity(tableName = "Grades")
class Grades(var grade: String, var date: Date, var subject: String, var task: String)