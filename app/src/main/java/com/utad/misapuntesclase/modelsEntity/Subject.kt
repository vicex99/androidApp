package com.utad.misapuntesclase.modelsEntity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "Subject")
class Subject(
    var imageID: Int,
    var name: String,
    var description: String,
    var recyclerViewDataArrayList: ArrayList<RecyclerViewData>?
) {
    @PrimaryKey(autoGenerate = false)
    var id: Int? = null
}