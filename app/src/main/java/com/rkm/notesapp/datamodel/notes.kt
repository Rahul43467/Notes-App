package com.rkm.notesapp.datamodel

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "NotesTable")
data class notes(
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    val priority: String?,
    val title: String?,
    val date: String?,
    val notes: String?
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }

    override fun writeToParcel(p0: Parcel, p1: Int) {
        TODO("Not yet implemented")
    }

    companion object CREATOR : Parcelable.Creator<notes> {
        override fun createFromParcel(parcel: Parcel): notes {
            return notes(parcel)
        }

        override fun newArray(size: Int): Array<notes?> {
            return arrayOfNulls(size)
        }
    }
}