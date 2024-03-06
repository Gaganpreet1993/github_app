package com.example.githubapp.data

data class RepoEntityData(
    val id: Int,
    val name: String,
    val language: String,
    val description: String? = null
)