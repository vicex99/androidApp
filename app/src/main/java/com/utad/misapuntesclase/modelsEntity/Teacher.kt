package com.utad.misapuntesclase.modelsEntity

import android.arch.persistence.room.Entity

@Entity(tableName = "Teacher")
class Teacher(
    var imageID: Int,
    var name: String,
    var surname: String,
    var recyclerViewDataArrayList: ArrayList<RecyclerViewData>
)