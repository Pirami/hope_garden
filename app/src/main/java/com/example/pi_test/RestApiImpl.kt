//package com.example.pi_test
//import retrofit2.Call
//import retrofit2.Callback
//import retrofit2.Response
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//
//// Retrofit 라이브러리를 가져옵니다.
//val retrofit = Retrofit.Builder()
//    .baseUrl("https://api.example.com/")
//    .addConverterFactory(GsonConverterFactory.create())
//    .build()
//
//// Retrofit 인터페이스를 생성합니다.
//interface ExampleApi {
//
//    @GET("/users")
//    fun getUsers(): Call<List<User>>
//
//}
//
//// Retrofit 인터페이스를 구현하는 클래스를 생성합니다.
//class RestApiImpl(private val retrofit: Retrofit) : ExampleApi {
//
//    override fun getUsers(): Call<List<User>> {
//        return retrofit.create(ExampleApi::class.java).getUsers()
//    }
//
//}
//
//// 클래스의 생성자에 Retrofit 인스턴스를 전달합니다.
//val exampleApi = ExampleApiImpl(retrofit)
//
//// 클래스의 메서드를 호출하여 REST API를 호출합니다.
//exampleApi.getUsers().enqueue(object : Callback<List<User>> {
//
//    override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
//        if (response.isSuccessful) {
//            // REST API 호출이 성공했습니다.
//            val users = response.body()
//            for (user in users) {
//                println(user.name)
//            }
//        } else {
//            // REST API 호출이 실패했습니다.
//            response.errorBody()?.let {
//                println(it.string())
//            }
//        }
//    }
//
//    override fun onFailure(call: Call<List<User>>, t: Throwable) {
//        // REST API 호출이 실패했습니다.
//        t.printStackTrace()
//    }
//
//})