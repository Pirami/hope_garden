package com.example.pi_test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import com.example.pi_test.databinding.ActivityPage3Binding

class MemberSearchView : AppCompatActivity() {
    private lateinit var binding: ActivityPage3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityPage3Binding.inflate(layoutInflater)
        setContentView(binding.root)
//
        val id = intent.getStringExtra("id")
        val name = intent.getStringExtra("name")
        val death = intent.getStringExtra("death")
        val churchName = intent.getStringExtra("churchName")
        val sex = intent.getStringExtra("sex")

        val reborn = intent.getStringExtra("reborn")
        val birth = intent.getStringExtra("birth")
        Log.d("name 확인11: ", name.toString())
        Log.d("churchName 확인11: ", churchName.toString())
        Log.d("sex 확인11: ", sex.toString())
        Log.d("death 확인11: ", death.toString())
//        Log.d("reborn 확인11: ", reborn.toString())
        Log.d("birth 확인11: ", birth.toString())

//        intent.putExtra("data", name)
//        intent.putExtra("churchName", churchName)
//        intent.putExtra("sex", sex)
//        intent.putExtra("id", id)
//        intent.putExtra("death", death)
//        intent.putExtra("reborn", reborn)
//        intent.putExtra("birth", birth)
//        Log.d("확인11: ", data.toString())
//detail_sex
        binding.detailName.text = name
        binding.detailSex.text = sex
        binding.detailDeath.text = death
        binding.detailBirth.text = birth
        binding.detailChurchName.text = churchName
        binding.detailReborn.text = reborn
//        binding.detailTitle.text = data!!.title
//        binding = ActivityPage3Binding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        val data = intent.getParcelableExtra<MemberVo>("data")
//
//        binding.detailCategory.text = data!!.profile
//        binding.detailTitle.text = data!!.title



        val homeBtn = findViewById<ImageButton>(R.id.ms_home_btn)
        val backBtn = findViewById<ImageButton>(R.id.ms_back_btn)
        val familyBtn = findViewById<ImageButton>(R.id.ms_family_btn)

        homeBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        backBtn.setOnClickListener {
            val intent = Intent(this, SearchMainActivity::class.java)
            startActivity(intent)
        }

        familyBtn.setOnClickListener {
            val intent = Intent(this, MemberSearchFamilyView::class.java)
            intent.putExtra("id", id);
            intent.putExtra("name", name);
            startActivity(intent)
        }

    }
    }