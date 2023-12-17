package com.example.pi_test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import com.example.pi_test.databinding.ActivityPageMsgBinding

class MemberSearchFamilyViewMsg : AppCompatActivity() {
    private lateinit var binding: ActivityPageMsgBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPageMsgBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = intent.getStringExtra("data")
        Log.d("확인11: ", data.toString())

        binding.memberName.text = data

        val homeBtn = findViewById<ImageButton>(R.id.ms_home_btn)
        val backBtn = findViewById<ImageButton>(R.id.ms_back_btn)

        homeBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
//
        backBtn.setOnClickListener {
            val intent = Intent(this, SearchMainActivity::class.java)
            startActivity(intent)
        }

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