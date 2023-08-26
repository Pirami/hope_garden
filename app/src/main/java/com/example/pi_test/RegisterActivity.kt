//package com.example.pi_test
//
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.widget.Button
//import android.widget.EditText
//
//
//class RegisterActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_register)
//
//        val registerBtn = findViewById<Button>(R.id.findBtn_mod)
//
//        val editTextname = findViewById<EditText>(R.id.editTextname)
//        val editTextage = findViewById<EditText>(R.id.editTextage)
//        val editTxtaddress = findViewById<EditText>(R.id.editTxtaddress)
//
//
//        registerBtn.setOnClickListener {
//            //seq는 어차피 DB에서 추가
//            val mem = Member(0,
//                editTextname.text.toString().trim(),
//                editTextage.text.toString().toInt(),
//                editTxtaddress.text.toString().trim())
//
//            val dbHelper = DBHelper.getInstance(this,"member.db",)//.insert(mem)해도 됨
//            dbHelper.insert(mem)
//
//
//
//        }
//
//
//
//
//
//    }
//}