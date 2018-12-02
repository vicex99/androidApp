package com.utad.misapuntesclase.modelsEntity

import android.arch.persistence.room.Entity
import android.os.Parcel
import android.os.Parcelable

@Entity
class RecyclerViewData(var data: String, var name: String) : Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(data)
        parcel.writeString(name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<RecyclerViewData> {
        override fun createFromParcel(parcel: Parcel): RecyclerViewData {
            return RecyclerViewData(parcel)
        }

        override fun newArray(size: Int): Array<RecyclerViewData?> {
            return arrayOfNulls(size)
        }
    }
}