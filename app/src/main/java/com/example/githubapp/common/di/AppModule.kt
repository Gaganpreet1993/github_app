package com.example.githubapp.common.di

import com.example.githubapp.domain.RepoInteractor
import com.example.githubapp.domain.RepoInteractorImpl
import com.example.githubapp.domain.UserInteractor
import com.example.githubapp.domain.UserInteractorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface AppModule {

    @Binds
    fun bindUserInteractor(impl: UserInteractorImpl): UserInteractor
    @Binds
    fun bindRepoInteractor(impl: RepoInteractorImpl): RepoInteractor
}