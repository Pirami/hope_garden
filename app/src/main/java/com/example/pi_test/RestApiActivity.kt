//package com.example.pi_test
//
//import android.util.Log
//import androidx.appcompat.app.AppCompatActivity
//import com.example.pi_test.Interface.DataApiService
//import com.example.pi_test.Interface.UserApi
//import com.example.pi_test.models.User
//import retrofit2.Call
//import retrofit2.Callback
//import retrofit2.Response
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//
//
//class RestApiActivity : AppCompatActivity() {
//
//    // 토큰과 사용자 정보를 생성합니다.
//    val token = "1234567890"
//    val user = User(
//        id = 1,
//        name = "John Doe",
//        email = "johndoe@example.com",
//        password = "password"
//    )
//
//    // API를 호출합니다.
//    val networkClient = NetworkClient()
//    val userApi = networkClient.createService(UserApi::class.java)
//    val call = userApi.createUser(user)
//
//    // API 호출 결과를 처리합니다.
//    call.enqueue(object : Callback<User> {
//        override fun onResponse(call: Call<User>, response: Response<User>) {
//            if (response.isSuccessful) {
//                // API 호출이 성공했습니다.
//                val user = response.body()
//                Log.d("MainActivity", "User created: $user")
//            } else {
//                // API 호출이 실패했습니다.
//                Log.e("MainActivity", "Error creating user: ${response.errorBody()}")
//            }
//        }
//
//        override fun onFailure(call: Call<User>, t: Throwable) {
//            // API 호출에 오류가 발생했습니다.
//            Log.e("MainActivity", "Error creating user: $t")
//        }
//    })
//
////
////    // 여기부터
////    val retrofit = Retrofit.Builder()
////        .baseUrl("https://api.jbch.org/")
////        .addConverterFactory(GsonConverterFactory.create())
////        .build()
////
////    val dateApiService = retrofit.create(DataApiService::class.java)
////    // 여기까지
////
////    private lateinit var binding: ActivityRestApiBinding
////    override fun onCreate(savedInstanceState: Bundle?) {
////        super.onCreate(savedInstanceState)
////        binding = ActivityRestApiBinding.inflate(layoutInflater)
////        val view = binding.root
////        setContentView(view)
////
////
////    }
//}