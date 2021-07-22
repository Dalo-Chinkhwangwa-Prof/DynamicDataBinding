package com.dynamicdevz.dynamicsecondlast.db

import android.database.Cursor
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.dynamicdevz.dynamicsecondlast.Grocery


@Dao
interface GroceryDAO {

    @Insert
    fun addGrocery(grocery: Grocery)

    @Query("SELECT * FROM groceries")
    fun getAllGroceries(): Cursor

    @Query("SELECT * FROM groceries WHERE id = :sId")
    fun getGroceryItem(sId: Int): Cursor

}