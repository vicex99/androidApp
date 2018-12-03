package com.utad.misapuntesclase.db

import android.arch.persistence.room.TypeConverter
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson
import java.util.*

//TODO: que te de un dao y te devuelva un recycle view

/*
RecyclerViewData("13", "Number of Alumns")


 */
object RecyclerViewConverter {
    @TypeConverter
    @ToJson
    @JvmStatic
    fun toRecyclerView(menuStamp: String?): RecyclerView? {
        menuStamp?.let {
//            return menuStamp
        } ?: kotlin.run { return null }
    }

    @TypeConverter
    @FromJson
    @JvmStatic
    fun toJSON(item: RecyclerView?): String {
        Log.d("toStringitem", item.toString())
        return item.toString()
    }
}