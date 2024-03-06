package com.example.githubapp.data

import com.google.gson.annotations.SerializedName

data class UserEntityData(
    val login: String,
    val id: Int,
    @SerializedName("avatar_url")
    val avatarUrl: String
)
