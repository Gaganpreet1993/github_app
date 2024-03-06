package com.example.githubapp.api


import com.example.githubapp.data.RepoDetailsEntityData
import com.example.githubapp.data.RepoEntityData
import com.example.githubapp.data.UserResponseData
import retrofit2.Response

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import rx.Observable


interface ApiService {

    @GET("search/users")
    fun getUsers(@Query("q") query: String): Observable<Response<UserResponseData>>

    @GET("users/{login}/repos")
    fun getRepos(@Path("login") login: String): Observable<Response<List<RepoEntityData>>>

    @GET("repos/{owner}/{repo}")
    fun getRepoDetails(@Path("owner") owner: String, @Path("repo") repo: String): Observable<Response<RepoDetailsEntityData>>

}