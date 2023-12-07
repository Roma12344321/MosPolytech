package com.example.mospolytech.domain

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "directions")
@Parcelize
data class Direction(
    @PrimaryKey
    val id: Int,
    val name: String,
    val passScore: String,
    val text: String,
    val work: String,
    val advantages : String,
    val favourite :Boolean = false
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
