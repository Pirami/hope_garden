package com.example.pi_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView

class DeleteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_main)

        val editTxtdelname = findViewById<EditText>(R.id.editTxtmodname)
        Log.d(editTxtdelname.toString(), ": 확인")
//        val textViewinfo_del = findViewById<TextView>(R.id.textViewinfo_mod)
        val findBtn_del = findViewById<ImageButton>(R.id.search_btn)
//        val deleteBtn = findViewById<Button>(R.id.search_btn)

        findBtn_del.setOnClickListener {

            val name = editTxtdelname.text.toString().trim()
            Log.d(name, ": 확인")
            val dbHelper = DBHelper.getInstance(this,"member.db",)
            val result = dbHelper.search(name)

//            textViewinfo_del.text = result
        }

//        deleteBtn.setOnClickListener {
//
//            val name = editTxtdelname.text.toString().trim()
//            val dbHelper = DBHelper.getInstance(this,"member.db")
////            dbHelper.delete(name)
//
//
//
//
//        }


    }
}