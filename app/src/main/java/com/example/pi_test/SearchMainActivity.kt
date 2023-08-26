package com.example.pi_test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.ImageButton

class SearchMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_main)
        val findBtn = findViewById<ImageButton>(R.id.search_btn)
        val homeBtn = findViewById<ImageButton>(R.id.home_btn)

        homeBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


        val editTxtdelname = findViewById<EditText>(R.id.editTxtmodname)
        Log.d(editTxtdelname.toString(), ": 확인")


        findBtn.setOnClickListener {
            val intent = Intent(this, SearchView::class.java)
            val name = editTxtdelname.text.toString().trim()
            Log.d("데이터 이름: ", name)
            intent.putExtra("데이터 이름", name)
            val dbHelper = DBHelper.getInstance(this,"member.db",)
            val result = dbHelper.search(name)
            Log.d("데이터 조회값: ", result)
            intent.putExtra("데이터 조회값", result)
            startActivity(intent)
//            textViewinfo_del.text = 름
        }
    }
}