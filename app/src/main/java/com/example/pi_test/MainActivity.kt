package com.example.pi_test
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import com.example.pi_test.Interface.UserApi
import com.example.pi_test.models.User
//import com.example.pi_test.models.Config
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
            // 토큰과 사용자 정보를 생성합니다.

            val token = "FLKFIQIQIEIRFNFVLQIEFOKQOIWJLSKNDVOEDOIWGHENFOA78F"
            val devName = "garden"
            val keyword = "황영희"
//            val config = Config(
//                tokenId = token,
//                dev_name = devName,
////                keyword = keyword
//
//            )
            // API를 호출합니다.
            val networkClient = NetworkClient()
            val userApi = networkClient.createService(UserApi::class.java)
            val call = userApi.getUser(devName, token)

            // API 호출 결과를 처리합니다.
            call.enqueue(object : Callback<User> {
                override fun onResponse(call: Call<User>, response: Response<User>) {
                    if (response.isSuccessful) {
                        // API 호출이 성공했습니다.
                        val user = response.body()
//                        Log.d("MainActivity", "User created: $user")
                        Log.d("MainActivity", "response created: ${response.toString()}")
                        // 응답 데이터 로그로 출력
                        Log.d("MainActivity", "Response data: ${response.message()}")
                    } else {
                        // API 호출이 실패했습니다.
                        Log.e("MainActivity", "Error creating user: ${response.errorBody()}")
                    }
                }

//                override fun onFailure(call: Call<config>, t: Throwable) {
//                    // API 호출에 오류가 발생했습니다.
//                    Log.e("MainActivity", "Error creating user: $t")
//                }

                override fun onFailure(call: Call<User>, t: Throwable) {
                                        // API 호출에 오류가 발생했습니다.
                    Log.e("MainActivity", "Error creating user: $t")
                }
            })
//            startActivity(Intent(this, RestApiActivity::class.java))
//                val chage = "upgrade"
//                val dbHelper = DBHelper.getInstance(this,"member.db")
//                val deceased = "" //api 데이터
//
//
//
//                dbHelper.chage(chage, deceased)


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