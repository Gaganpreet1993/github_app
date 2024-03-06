package com.example.githubapp.data
import com.google.gson.annotations.SerializedName

data class RepoDetailsEntityData(
    @SerializedName("name") val name: String,
    @SerializedName("html_url") val htmlUrl: String,
    @SerializedName("description") val description: String?,
    @SerializedName("created_at") val createdAt: String?,
    @SerializedName("forks") val forks: Long,
    @SerializedName("language") val language: String?,
    @SerializedName("open_issues_count") val openIssuesCount: Long,
    @SerializedName("subscribers_count") val subscribersCount: Long
)