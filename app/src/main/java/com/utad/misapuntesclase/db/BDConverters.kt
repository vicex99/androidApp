package com.utad.misapuntesclase.db

import android.arch.persistence.room.TypeConverter
import android.net.Uri
import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson
import com.google.gson.Gson
import com.utad.misapuntesclase.modelsEntity.Gender
import com.utad.misapuntesclase.modelsEntity.RecyclerViewData
import java.util.*
import com.google.gson.reflect.TypeToken




//TODO: que te de un dao y te devuelva un recycle view

object RecyclerViewConverter {
    @TypeConverter
    @ToJson
    @JvmStatic
    fun toList(list: String): RecyclerViewData? {
        val listType = object : TypeToken<ArrayList<RecyclerViewData>>() {

        }.type
        return Gson().fromJson(list, RecyclerViewData::class.java)
    }

    @TypeConverter
    @FromJson
    @JvmStatic
    fun toJSON(item: RecyclerViewData): String {
        return Gson().toJson(item, RecyclerViewData::class.java)
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
    fun toJSON(date: Date?): Long? {
        return date?.time
    }
}

object GenderConverter {
    @TypeConverter
    @ToJson
    @JvmStatic
    fun toGender(item: String?): Gender? {
        item?.let {
            if (Gender.female.toString() == it){
                return Gender.female
            }else {
                return Gender.male
            }
        } ?: kotlin.run { return Gender.male }
    }

    @TypeConverter
    @FromJson
    @JvmStatic
    fun toJSON(item: Gender?): String? {
        item?.let {
            if (Gender.female == it){
                return "female"
            }else {
                return "male"
            }
        } ?: kotlin.run { return "male" }
    }
}

object ImgUriConverter {
    @TypeConverter
    @ToJson
    @JvmStatic
    fun toUri(item: String?): Uri? {
        return Uri.parse(item);
    }

    @TypeConverter
    @FromJson
    @JvmStatic
    fun toJSON(item: Uri?): String? {
        return item.toString()
    }
}
