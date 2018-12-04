package com.utad.misapuntesclase.modelsEntity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.arch.persistence.room.TypeConverters
import com.utad.misapuntesclase.db.RecyclerViewConverter

@Entity(tableName = "Community")
class Community(
    var name: String,
    var imageID: Int,
    var description: String,
    var cordinator: String,
    @TypeConverters(RecyclerViewConverter::class)
    var recyclerViewDataArrayList: ArrayList<RecyclerViewData>
) {
    @PrimaryKey(autoGenerate = false)
    var id: Int? = null
}