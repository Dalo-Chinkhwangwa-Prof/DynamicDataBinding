package com.dynamicdevz.dynamicsecondlast

import android.content.ContentProvider
import android.content.ContentValues
import android.content.UriMatcher
import android.database.Cursor
import android.net.Uri
import androidx.room.Room
import com.dynamicdevz.dynamicsecondlast.db.GroceryDB

class DynamicContent : ContentProvider() {

    private val ALL_ITEMS = 0
    private val SINGLE_ITEM = 1

    //content://com.dynamicdevz.dynamicsecondlast.provider/groceries/1
    //content://com.dynamicdevz.dynamicsecondlast.provider/groceries

    val uriMatcher = UriMatcher(UriMatcher.NO_MATCH).also {
        it.addURI("com.dynamicdevz.dynamicsecondlast.provider", "groceries", ALL_ITEMS)
        it.addURI("com.dynamicdevz.dynamicsecondlast.provider", "groceries/#", SINGLE_ITEM)
    }

    private lateinit var database: GroceryDB

    override fun onCreate(): Boolean {
        context?.let {
            database = Room.databaseBuilder(
                it,
                GroceryDB::class.java,
                "grocery.db"
            ).allowMainThreadQueries()
                .build()
        }
        return this::database.isInitialized
    }

    override fun query(
        p0: Uri,
        p1: Array<out String>?,
        p2: String?,
        p3: Array<out String>?,
        p4: String?
    ): Cursor? {

        return when (uriMatcher.match(p0)) {
            ALL_ITEMS -> {
                database.getDao().getAllGroceries()
            }
            else -> {
                val id = p0.lastPathSegment?.toInt() ?: 1
                return database.getDao().getGroceryItem(id)
            }

        }


    }

    override fun getType(p0: Uri): String? = null


    override fun insert(p0: Uri, p1: ContentValues?): Uri? = null

    override fun delete(p0: Uri, p1: String?, p2: Array<out String>?): Int = 0

    override fun update(p0: Uri, p1: ContentValues?, p2: String?, p3: Array<out String>?): Int  = 0
}