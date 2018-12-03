package com.utad.misapuntesclase.db

import android.arch.persistence.room.TypeConverter
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.google.gson.Gson
import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson
import com.utad.misapuntesclase.modelsEntity.RecyclerViewData
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

        var jsonArray2 = Gson().fromJson(menuStamp, RecyclerViewData::class.java)

        return null
    }

    @TypeConverter
    @FromJson
    @JvmStatic
    fun toJSON(item: RecyclerView?): String {
        Log.d("toStringitem", item.toString())
        return item.toString()
    }
}

object DateConverter {
    @TypeConverter
    @ToJson
    @JvmStatic
    fun toDate(timestamp: Long?): Date? {
        return if (timestamp == null) null
        else Date(timestamp)
    }

    @TypeConverter
    @FromJson
    @JvmStatic
    fun toTimestamp(date: Date?): Long? {
        return date?.time
    }
}