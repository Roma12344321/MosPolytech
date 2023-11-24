package com.example.mospolytech.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Direction(
    val id: Int,
    val name: String,
    val passScore: String,
    val text: String,
    val work: String,
    val advantages : String,
//    val code : String,
//    val speciality : String,
//    val fac : String,
//    val formOfEducation : String,
//    val level: String,
//    val campus : String,
//    val budget : Int,
//    val plat : Int,
//    val cost : String,
//    val objects: String,
//    val profileObjects : String,
//    val skills : String
) : Parcelable
