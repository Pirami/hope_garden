//package com.example.pi_test
//
//import android.content.Intent
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.util.Log
//import android.widget.Button
//import android.widget.EditText
//import android.widget.ImageButton
//import android.widget.TextView
//
//class SearchActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_search_main)
//
//        val homeBtn = findViewById<ImageButton>(R.id.home_btn)
//
//        homeBtn.setOnClickListener {
//            val intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)
//        }
//
//
//        val editTextName = findViewById<EditText>(R.id.editTxtmodname)
//        val name = editTextName.text.toString().trim()
//        Log.d("editTxtname: ", name)
//        val findBtn = findViewById<ImageButton>(R.id.search_btn)
//
//        findBtn.setOnClickListener {
//            val intent = Intent(this, SearchView::class.java)
//            Log.d("데이터 이름: ", name)
//            intent.putExtra("데이터 이름", name)
//            val dbHelper = DBHelper.getInstance(this,"member.db",)
//            val result = dbHelper.search(name)
//            Log.d("데이터 조회값: ", result)
//
////            textViewinfo.text = result
//            startActivity(intent)
//
//        }
//
//    }
//}