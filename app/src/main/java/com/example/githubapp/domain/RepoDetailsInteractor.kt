package com.example.githubapp.domain

import com.example.githubapp.api.ApiConfig
import com.example.githubapp.data.RepoDetailsEntityData
import javax.inject.Inject

class RepoDetailsInteractor @Inject constructor(){
    fun getReposDetails(owner: String, repo: String): rx.Observable<RepoDetailsEntityData> =
        ApiConfig.getApiService()
            .getRepoDetails(owner, repo)
            .map {
                if (it.isSuccessful) it.body() else throw RuntimeException("Unable get Repositories info")
            }
}