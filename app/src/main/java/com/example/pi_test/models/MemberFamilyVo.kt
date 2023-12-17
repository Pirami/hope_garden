package com.example.pi_test.models

import com.google.gson.annotations.SerializedName

data class MemberFamilyVo(
    @SerializedName("id") val id: String,
    @SerializedName("aId") val aId: String,
    @SerializedName("chId") val chId: String,
    @SerializedName("name") val name: String,
    @SerializedName("relationship") val relationship: String,
    @SerializedName("phone") val phone: String,
    @SerializedName("userid") val userid: String,
    @SerializedName("created") val created: String,
    @SerializedName("insort") val insort: String,
    @SerializedName("fa_churchname") val fa_churchname: String,
    @SerializedName("as_name") val as_name: String,
    @SerializedName("as_sex") val as_sex: String,
    @SerializedName("profile") val profile: String,
    @SerializedName("death") val death: String,
    @SerializedName("as_churchname") val as_churchname: String
)
//data class MemberVo<T>(
//    @SerializedName("id") val id: Int,
//    @SerializedName("profile") val profile: String,
//    @SerializedName("name") val name: String,
//    @SerializedName("sex") val sex: String,
//    @SerializedName("chId") val chId: String,
//    @SerializedName("title") val title: Int,
//    @SerializedName("birth") val birth: String,
//    @SerializedName("reborn") val reborn: String,
//    @SerializedName("death") val death: String,
//    @SerializedName("asleep") val asleep: String,
//    @SerializedName("userId") val userId: String,
//    @SerializedName("created") val created: String,
//    @SerializedName("updater") val updater: String,
//    @SerializedName("updated") val updated: String,
//    @SerializedName("churchName") val churchName: String
//
//
//)


