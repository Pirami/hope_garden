package com.example.pi_test.models

import com.google.gson.annotations.SerializedName

class Search(
    @SerializedName("id") val id: String,
    @SerializedName("profile") val profile: String,
    @SerializedName("name") val name: String,
    @SerializedName("death") val death: String,
    @SerializedName("churchname") val churchName: String,
    @SerializedName("asleep") val asleep: String,
    @SerializedName("sex") val sex: String,
    @SerializedName("reborn") val reborn: String,
    @SerializedName("birth") val birth: String

//    @SerializedName("chId") val chId: String,
//    @SerializedName("title") val title: String,
//    @SerializedName("userid") val userId: String,
//    @SerializedName("created") val created: String,
//    @SerializedName("updater") val updater: String,
//    @SerializedName("updated") val updated: String,


)
