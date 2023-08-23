package com.example.pi_test
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page)

        val mainBtn = findViewById<ImageButton>(R.id.btn)

        val updateBtn = findViewById<ImageButton>(R.id.data_update_btn)
//
//        val delBtn = findViewById<Button>(R.id.delBtn)
//
//        val searchBtn = findViewById<Button>(R.id.searchBtn)
//
//        val modBtn = findViewById<Button>(R.id.modBtn)
//
//        val printBtn = findViewById<Button>(R.id.printBtn)

        mainBtn.setOnClickListener {
            val intent = Intent(this, SearchActivity::class.java)
            startActivity(intent)
        }
        // 아이콘 버튼 클릭시 : DB Table 업데이트 작업  -> 보완 함부로 데이터가 삭제되지 않도록 보안 걸어둘 필요 있음.
        updateBtn.setOnClickListener {
                val chage = "upgrade"
                val dbHelper = DBHelper.getInstance(this,"member.db",)
                dbHelper.chage(chage)


            // Rest API 호출해서 Data 가져오는 과정
//            val mem = Member(0,
//                editTextname.text.toString().trim(),
//                editTextage.text.toString().toInt(),
//                editTxtaddress.text.toString().trim())
//
//            val dbHelper = DBHelper.getInstance(this,"member.db",)//.insert(mem)해도 됨
//            dbHelper.insert(mem)
        }
//
//        searchBtn.setOnClickListener {
//            val intent = Intent(this, SearchActivity::class.java)
//            startActivity(intent)
//        }
//
//        modBtn.setOnClickListener {
//            val intent = Intent(this, ReviseActivity::class.java)
//            startActivity(intent)
//        }
//
//        printBtn.setOnClickListener {
//            val intent = Intent(this, AllmemberActivity::class.java)
//            startActivity(intent)
//
//        }
    }
}