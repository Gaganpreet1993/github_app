package com.example.githubapp.domain

import com.example.githubapp.api.ApiConfig
import com.example.githubapp.data.RepoEntityData
import com.example.githubapp.data.UserEntityData
import rx.Observable
import javax.inject.Inject

interface RepoInteractor {
    fun getRepos(query: String): rx.Observable<List<RepoEntityData>>
}

class RepoInteractorImpl @Inject constructor(): RepoInteractor{
    override fun getRepos(query: String): rx.Observable<List<RepoEntityData>> = ApiConfig.getApiService()
        .getRepos(query)
        .map { if (it.isSuccessful) it.body() else emptyList() }
}