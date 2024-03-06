package com.example.githubapp.domain

import com.example.githubapp.api.ApiConfig
import com.example.githubapp.data.UserEntityData
import rx.Observable
import javax.inject.Inject

interface UserInteractor {
    fun getUsers(query: String): Observable<List<UserEntityData>>
}

class UserInteractorImpl @Inject constructor(): UserInteractor  {
     override fun getUsers(query: String): rx.Observable<List<UserEntityData>> = ApiConfig.getApiService()
        .getUsers(query)
        .map { if (it.isSuccessful) it.body()?.items else emptyList() }
}