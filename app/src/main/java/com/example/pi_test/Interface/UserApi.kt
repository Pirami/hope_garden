package com.example.pi_test.Interface

import com.example.pi_test.models.MemberVo
import com.example.pi_test.models.User
import com.example.pi_test.models.UserFamilyList
//import com.example.pi_test.models.Config
import retrofit2.Call
import retrofit2.http.*
//{"dev_name" : "garden",
//    "tokenId":"FLKFIQIQIEIRFNFVLQIEFOKQOIWJLSKNDVOEDOIWGHENFOA78F",
//    "keyword" : "황영희"
//}

interface UserApi {

//    @POST("/ex/load_asleep.php")
//    fun createUser(@Body config: Config): Call<List<User>>
    @GET("/ex/load_asleep.php")
    fun getUser(@Query("dev_name") devName: String, @Query("tokenId") tokenId: String): Call<User>

    @POST("/ex/load_asleep_family.php")
    fun getUserFamily(@Query("dev_name") devName: String, @Query("tokenId") tokenId: String): Call<UserFamilyList> //Call<User> 가 아닌 유가족 List 로 바꿔야함.

    @POST("/ex/load_asleep_guestbook.php")
    fun getGuestBook(@Query("dev_name") devName: String, @Query("tokenId") tokenId: String, @Query("aId") aId: String): Call<UserFamilyList> //Call<User> 가 아닌 유가족 List 로 바꿔야함.


//    @PUT("/users/{id}")
//    fun updateUser(@Path("id") id: Int, @Body user: User): Call<User>
//
//    @DELETE("/users/{id}")
//    fun deleteUser(@Path("id") id: Int): Call<User>
}