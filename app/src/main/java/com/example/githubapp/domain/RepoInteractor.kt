package com.example.githubapp.domain

import com.example.githubapp.api.ApiConfig
import com.example.githubapp.data.RepoEntityData
import javax.inject.Inject

class RepoInteractor @Inject constructor() {
    fun getRepos(query: String): rx.Observable<List<RepoEntityData>> = ApiConfig.getApiService()
        .getRepos(query)
        .map { if (it.isSuccessful) it.body() else emptyList() }
}