package com.example.testlib.testEntity.bean

import android.os.Parcel
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/***
 * parcelable类的unittest
 */
@RunWith(AndroidJUnit4::class)
class ParcelableObjectUnitTest {
    @Before
    fun setup() {
    }

    @Test
    fun build() {
        val parcelableObject = ParcelableObject("name")

        var parcel: Parcel = Parcel.obtain()
        parcelableObject.writeToParcel(parcel, 0)
        val marshall = parcel.marshall()
        parcel.recycle()

        var parcel2: Parcel = Parcel.obtain()
        parcel2.unmarshall(marshall, 0, marshall.size)
        parcel2.setDataPosition(0)
        val createFromParcel = ParcelableObject.createFromParcel(parcel2)
    }
}