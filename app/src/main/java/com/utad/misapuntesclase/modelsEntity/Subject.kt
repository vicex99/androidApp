package com.utad.misapuntesclase.modelsEntity

import android.arch.persistence.room.Entity

@Entity(tableName = "Subject")
class Subject(
    var id: Int,
    var imageID: Int,
    var name: String,
    var description: String,
    var recyclerViewDataArrayList: ArrayList<RecyclerViewData>?
)