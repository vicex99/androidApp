package com.utad.misapuntesclase.modelsEntity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.arch.persistence.room.TypeConverters
import com.utad.misapuntesclase.db.RecyclerViewConverter

@Entity(tableName = "Subject")
class Subject(
    var imageID: Int,
    var name: String,
    var description: String,
    @TypeConverters(RecyclerViewConverter::class)
    var recyclerViewDataArrayList: ArrayList<RecyclerViewData>
) {
    @PrimaryKey(autoGenerate = false)
    var id: Int? = null
}