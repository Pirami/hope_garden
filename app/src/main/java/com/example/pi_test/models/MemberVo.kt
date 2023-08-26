package com.example.pi_test.models

import com.google.gson.annotations.SerializedName

data class MemberVo(
    @SerializedName("id") val id: Int,
    @SerializedName("profile") val profile: String,
    @SerializedName("name") val name: String,
    @SerializedName("sex") val sex: String,
    @SerializedName("chId") val chId: String,
    @SerializedName("title") val title: Int,
    @SerializedName("birth") val birth: String,
    @SerializedName("reborn") val reborn: String,
    @SerializedName("death") val death: String,
    @SerializedName("asleep") val asleep: String,
    @SerializedName("userId") val userId: String,
    @SerializedName("created") val created: String,
    @SerializedName("updater") val updater: String,
    @SerializedName("updated") val updated: String,
    @SerializedName("churchName") val churchName: String
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