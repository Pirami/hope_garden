package com.example.pi_test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pi_test.databinding.ActivityPageFamilyBinding

class MemberSearchFamilyView : AppCompatActivity() {
    private lateinit var binding: ActivityPageFamilyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPageFamilyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id = intent.getStringExtra("id")
        val aId = intent.getStringExtra("aId")
        val name = intent.getStringExtra("name")
        val relationship = intent.getStringExtra("relationship")
        val phone = intent.getStringExtra("phone")
        val chId = intent.getStringExtra("chId")

        binding.detailName.text = id
        binding.detailSex.text = aId
        binding.detailDeath.text = name
        binding.detailBirth.text = relationship
        binding.detailChurchName.text = phone
        binding.detailReborn.text = chId

        val homeBtn = findViewById<ImageButton>(R.id.home_btn)
        val backBtn = findViewById<ImageButton>(R.id.back_btn)
        val nameSearch = findViewById<TextView>(R.id.name_search)

        homeBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        backBtn.setOnClickListener {
            val intent = Intent(this, SearchMainActivity::class.java)
            startActivity(intent)
        }



        val data = intent.getStringExtra("데이터 이름")
//        val data = "test"
        if (data != null) {
            Log.d("data 조회값: ", data)
        }

        val dbHelper = DBHelper.getInstance(this,"member.db",)
        val result = data?.let { dbHelper.MembersFamily(it) }
        if (result != null) {
            Log.d("데이터 조회값: ", result[0].name)
        }
        nameSearch.text = data

        val recyclerViewNews = binding.recyclerView
        val newsAdapter = result?.let { TagRecyclerAdapter(it) }

        //어댑터 설정
        recyclerViewNews.adapter = newsAdapter
        recyclerViewNews.layoutManager = LinearLayoutManager(this)

//
//        binding.detailName.text = data
//        binding.detailSex.text = data!!.sex
//        binding.detailDeath.text = data!!.death
//        binding.detailBirth.text = data!!.birth
//        binding.detailChurchName.text = data!!.churchName
//        binding.detailReborn.text = data!!.reborn
//        binding.detailTitle.text = data!!.title
//        binding = ActivityPage3Binding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        val data = intent.getParcelableExtra<MemberVo>("data")
//
//        binding.detailCategory.text = data!!.profile
//        binding.detailTitle.text = data!!.title

    }
    }