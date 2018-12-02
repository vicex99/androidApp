package com.utad.misapuntesclase.modelsEntity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "Teacher")
class Teacher(
    var imageID: Int,
    var name: String,
    var surname: String,
    var recyclerViewDataArrayList: ArrayList<RecyclerViewData>
) {
    @PrimaryKey(autoGenerate = false)
    var id: Int? = null
}