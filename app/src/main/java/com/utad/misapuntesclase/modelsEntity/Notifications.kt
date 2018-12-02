package com.utad.misapuntesclase.modelsEntity


import java.util.*
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "Notifications")
class Notifications(var username: String, var date: Date, var title: String) {
    @PrimaryKey(autoGenerate = false)
    var id: Int? = null
}