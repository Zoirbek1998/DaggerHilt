package com.example.daggerhilt.model


import com.google.gson.annotations.SerializedName

data class UserData(
    @SerializedName("address")
    val address: Address? = null,
    @SerializedName("company")
    val company: Company? = null,
    @SerializedName("email")
    val email: String? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("phone")
    val phone: String? = null,
    @SerializedName("username")
    val username: String? = null,
    @SerializedName("website")
    val website: String? = null
)