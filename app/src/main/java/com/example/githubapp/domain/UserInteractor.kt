package com.example.githubapp.domain

import com.example.githubapp.api.ApiConfig
import com.example.githubapp.data.UserEntityData
import javax.inject.Inject


class UserInteractor @Inject constructor() {
    fun getUsers(query: String): rx.Observable<List<UserEntityData>> = ApiConfig.getApiService()
        .getUsers(query)
        .map { if (it.isSuccessful) it.body()?.items else emptyList() }
}