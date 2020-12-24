package com.faisal.submissionbfaafaisal1

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Data (
    var username : String? ,
    var repository : String?,
    var company : String? ,
    var name : String? ,
    var location : String? ,
    var following : String? ,
    var folowers : String? ,
    var avatar : Int ) : Parcelable