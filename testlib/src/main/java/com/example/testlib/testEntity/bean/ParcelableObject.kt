package com.example.testlib.testEntity.bean

import android.os.Parcel
import android.os.Parcelable

data class ParcelableObject(val name: String?) : Parcelable {
    constructor(parcel: Parcel) : this(parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ParcelableObject> {
        override fun createFromParcel(parcel: Parcel): ParcelableObject {
            return ParcelableObject(parcel)
        }

        override fun newArray(size: Int): Array<ParcelableObject?> {
            return arrayOfNulls(size)
        }
    }


}