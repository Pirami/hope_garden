package com.example.pi_test
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import com.example.pi_test.Interface.UserApi
import com.example.pi_test.models.User
import com.example.pi_test.models.UserFamilyList
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
            val intent = Intent(this, SearchMainActivity::class.java)
            startActivity(intent)
        }
        // 아이콘 버튼 클릭시 : DB Table 업데이트 작업  -> 보완 함부로 데이터가 삭제되지 않도록 보안 걸어둘 필요 있음.
        updateBtn.setOnClickListener {
            // 토큰과 사용자 정보를 생성합니다.
            val token = "FLKFIQIQIEIRFNFVLQIEFOKQOIWJLSKNDVOEDOIWGHENFOA78F"
            val devName = "garden"
//            val keyword = "황영희"
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
            val family_call = userApi.getUserFamily(devName, token)
            val gestBook_call = userApi.getGuestBook(devName, token, aId = "") //추후 aid 추가해야함.

            // API 호출 결과를 처리합니다.
            call.enqueue(object : Callback<User> {
                override fun onResponse(call: Call<User>, response: Response<User>) {
                    if (response.isSuccessful) {
                        // API 호출이 성공했습니다.
                        val user = response.body()
                        val activity = this@MainActivity
                        val dbHelper = DBHelper.getInstance(activity, "member.db")
                        dbHelper.upgrade("upgrade")
//                        Log.d("MainActivity", "User created: $user")
                        Log.d("MainActivity", "response created: ${response.body()?.result}")

//                        val memberVoList = api.getMemberVoList().execute().body()
                        val memberVoList = response.body()?.result
                        if (memberVoList != null) {
                            for (memberVo in memberVoList) {
                                Log.d("memberVo", "memberVo data: ${memberVo}")
                                dbHelper.insertMembers(memberVo)
                            }
                            Log.d("MainActivity", "모든 data insert : 완료")
                        }
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

            // API 호출 결과를 처리합니다.
            family_call.enqueue(object : Callback<UserFamilyList> {
                override fun onResponse(call: Call<UserFamilyList>, response: Response<UserFamilyList>) {
                    if (response.isSuccessful) {
                        // API 호출이 성공했습니다.
                        val user = response.body()
                        val activity = this@MainActivity
                        val dbHelper = DBHelper.getInstance(activity, "member.db")
                        dbHelper.upgrade("upgrade")
//                        Log.d("MainActivity", "User created: $user")
                        Log.d("MainActivity", "response created: ${response.body()?.result}")

//                        val memberVoList = api.getMemberVoList().execute().body()
                        val memberVoList = response.body()?.result
                        if (memberVoList != null) {
                            for (memberVo in memberVoList) {
                                Log.d("memberVo", "memberVo data: ${memberVo}")
//                                임시주석
//                                dbHelper.insertMembersFamily(memberVo)
                            }
                            Log.d("MainActivity", "모든 data insert : 완료")
                        }
                    } else {
                        // API 호출이 실패했습니다.
                        Log.e("MainActivity", "Error creating user: ${response.errorBody()}")
                    }
                }
                override fun onFailure(call: Call<UserFamilyList>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            })
        }
    }
}