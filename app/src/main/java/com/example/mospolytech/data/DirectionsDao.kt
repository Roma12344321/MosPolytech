package com.example.mospolytech.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mospolytech.domain.Direction

@Dao
interface DirectionsDao {
    @Query("SELECT * FROM directions")
    fun getAllFavouriteDirections(): LiveData<List<Direction>>

    @Query("SELECT * FROM directions WHERE id=:id")
    fun getFavouriteDirection(id: Int): LiveData<Direction>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addFavouriteDirection(direction: Direction)
    @Query("DELETE FROM directions WHERE id=:id")
    suspend fun deleteFavouriteDirection(id:Int)
}