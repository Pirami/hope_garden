package com.example.pi_test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView

class SearchView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page_2)

        val homeBtn = findViewById<ImageButton>(R.id.home_btn)

        homeBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val backBtn = findViewById<ImageButton>(R.id.back_btn)

        backBtn.setOnClickListener {
            val intent = Intent(this, SearchActivity::class.java)
            startActivity(intent)
        }

        val intent = intent
        val data = intent.getStringExtra("데이터 이름")
//
//        val editTxtname = findViewById<EditText>(R.id.search_view)
////        val textViewinfo = findViewById<TextView>(R.id.textViewinfo)
//        val findBtn = findViewById<ImageButton>(R.id.search_btn)
//
//        findBtn.setOnClickListener {
//            val intent = Intent(this, DataUpdateActivity::class.java)
//            startActivity(intent)
//            val name = editTxtname.text.toString().trim()
////            val dbHelper = DBHelper.getInstance(this,"member.db",)
////            val result = dbHelper.search(name)
//
////            textViewinfo.text = result
//
//        }

    }
}