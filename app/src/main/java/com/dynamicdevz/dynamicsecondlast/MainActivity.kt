package com.dynamicdevz.dynamicsecondlast

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.databinding.DataBindingUtil
import androidx.room.Room
import com.dynamicdevz.dynamicsecondlast.databinding.ActivityMainBinding
import com.dynamicdevz.dynamicsecondlast.db.GroceryDB

class MainActivity : AppCompatActivity() {

    private lateinit var inputET: EditText

    private val viewModel = MainViewModel()

    private lateinit var databinding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        databinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        databinding.viewModel = viewModel

        viewModel.makeAPICall()

        inputET = findViewById(R.id.input_edittext)

        findViewById<Button>(
            R.id.submit_button
        ).setOnClickListener {
            startActivity(
                Intent(this, DisplayActivity::class.java).also {
                    it.putExtra("NAME_KEY", inputET.text.toString().trim())
                }
            )
        }
        
        
        val db = Room.databaseBuilder(
            this,
            GroceryDB::class.java,
            "grocery.db"
        ).allowMainThreadQueries()
            .build()

        db.getDao().addGrocery(Grocery(1, "Spinach", 1.79))
        db.getDao().addGrocery(Grocery(2, "Pear", 0.79))
        db.getDao().addGrocery(Grocery(3, "Cherry", 3.00))
        db.getDao().addGrocery(Grocery(4, "Toilet Paper", 1.79))
        db.getDao().addGrocery(Grocery(5, "Chicken", 5.79))

    }
}








