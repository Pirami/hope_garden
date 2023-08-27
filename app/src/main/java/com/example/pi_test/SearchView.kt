package com.example.pi_test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pi_test.databinding.ActivityPage2Binding

class SearchView : AppCompatActivity() {
    private lateinit var binding: ActivityPage2Binding
    private lateinit var manager: RecyclerView.LayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_page_2)

        // ActivityMainBinding을 초기화합니다.
        binding = ActivityPage2Binding.inflate(layoutInflater)

        // ActivityPage2Binding을 setContentView로 설정합니다.
        setContentView(binding.root)

        manager = GridLayoutManager(this, 3)

        val homeBtn = findViewById<ImageButton>(R.id.home_btn)
        val nameSearch = findViewById<TextView>(R.id.name_search)
//        val textViewinfoMod = findViewById<TextView>(R.id.textViewinfo_mod)

        homeBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val backBtn = findViewById<ImageButton>(R.id.back_btn)

        backBtn.setOnClickListener {
            val intent = Intent(this, SearchMainActivity::class.java)
            startActivity(intent)
        }

        val data = intent.getStringExtra("데이터 이름")
        val dbHelper = DBHelper.getInstance(this,"member.db",)
        val result = data?.let { dbHelper.search(it) }
        if (result != null) {
            Log.d("데이터 조회값: ", result[0].name)
        }
        nameSearch.text = data

        val recyclerViewNews = binding.recyclerView
        val newsAdapter = result?.let { TagRecyclerAdapter(it) }

        recyclerViewNews.adapter = newsAdapter
        recyclerViewNews.layoutManager = LinearLayoutManager(this)
        recyclerViewNews.setHasFixedSize(true)
    }
}