package com.utad.misapuntesclase.modelsEntity


import java.util.*
import android.arch.persistence.room.Entity

@Entity(tableName = "Notifications")
class Notifications(var username: String, var date: Date, var title: String)