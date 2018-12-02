package com.utad.misapuntesclase.modelsEntity

import android.arch.persistence.room.Entity

@Entity(tableName = "Community")
class Community(
    var name: String,
    var imageID: Int,
    var description: String,
    var cordinator: String,
    var recyclerViewDataArrayList: ArrayList<RecyclerViewData>
)