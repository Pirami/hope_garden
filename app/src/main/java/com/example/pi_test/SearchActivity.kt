package com.example.pi_test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView

class SearchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_main)

        val homeBtn = findViewById<ImageButton>(R.id.home_btn)

        homeBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val editTxtname = findViewById<EditText>(R.id.search_view)
//        val textViewinfo = findViewById<TextView>(R.id.textViewinfo)
        val findBtn = findViewById<ImageButton>(R.id.search_btn)

        findBtn.setOnClickListener {
            val intent = Intent(this, SearchView::class.java)
            startActivity(intent)
//            val name = editTxtname.text.toString().trim()
//            val dbHelper = DBHelper.getInstance(this,"member.db",)
//            val result = dbHelper.search(name)

//            textViewinfo.text = result

        }

    }
}