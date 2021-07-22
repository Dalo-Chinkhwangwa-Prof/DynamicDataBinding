package com.dynamicdevz.dynamicsecondlast.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dynamicdevz.dynamicsecondlast.Grocery

@Database(version = 1, entities = [Grocery::class])
abstract class GroceryDB : RoomDatabase() {
    abstract fun getDao(): GroceryDAO
}