package com.example.mospolytech.data

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mospolytech.domain.Direction

@Database(entities = [Direction::class], version = 1, exportSchema = false)
abstract class AppDataBase : RoomDatabase() {

    abstract fun directionsDao(): DirectionsDao

    companion object {
        private var INSTANCE: AppDataBase? = null
        private val LOCK = Any()

        fun getInstance(application: Application): AppDataBase {
            INSTANCE?.let {
                return it
            }
            synchronized(LOCK) {
                INSTANCE?.let {
                    return it
                }
            }
            val db =
                Room.databaseBuilder(application, AppDataBase::class.java, "directs.db")
                    .allowMainThreadQueries()
                    .build()
            INSTANCE = db
            return db
        }
    }
}