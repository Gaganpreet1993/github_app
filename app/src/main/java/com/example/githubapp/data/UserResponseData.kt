package com.example.githubapp.data

import com.google.gson.annotations.SerializedName

data class UserResponseData(
    @SerializedName("total_count")
    val total: Int,
    @SerializedName("items")
    val items: List<UserEntityData>
)
