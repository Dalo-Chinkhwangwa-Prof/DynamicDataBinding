package com.dynamicdevz.dynamicsecondlast

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DisplayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        intent.getStringExtra("NAME_KEY")?.let {
            findViewById<TextView>(R.id.output_textview).text = it.uppercase()

        }


    }
}