package com.example.githubapp.ui.mainScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {

    private val _repoData = MutableLiveData<List<RepoAdapter.Repo>>()
    val repoData: LiveData<List<RepoAdapter.Repo>> = _repoData

    private val _userName = MutableLiveData<String>()
    val userName: LiveData<String> = _userName

    private val _userPhoto = MutableLiveData<String>()
    val userPhoto: LiveData<String> = _userPhoto


    fun fetchUserInfo(userId: String){
        _userName.postValue("The Geek")
        _userPhoto.postValue("https://newprofilepic.photo-cdn.net//assets/images/article/profile.jpg?90af0c8")
    }

    fun fetchUserRepos(userId: String) {
        // Simulate fetching data from API
        val sampleData = listOf(
            RepoAdapter.Repo("Repo 1", "Description 1"),
            RepoAdapter.Repo("Repo 2", "Description 2"),
            RepoAdapter.Repo("Repo 3", "Description 3"),
            RepoAdapter.Repo("Repo 1", "Description 1"),
            RepoAdapter.Repo("Repo 2", "Description 2"),
            RepoAdapter.Repo("Repo 3", "Description 3"),
            RepoAdapter.Repo("Repo 1", "Description 1"),
            RepoAdapter.Repo("Repo 2", "Description 2"),
            RepoAdapter.Repo("Repo 3", "Description 3"),
            RepoAdapter.Repo("Repo 1", "Description 1"),
            RepoAdapter.Repo("Repo 2", "Description 2"),
            RepoAdapter.Repo("Repo 3", "Description 3"),
            RepoAdapter.Repo("Repo 1", "Description 1"),
            RepoAdapter.Repo("Repo 2", "Description 2"),
            RepoAdapter.Repo("Repo 3", "Description 3"),
            RepoAdapter.Repo("Repo 1", "Description 1"),
            RepoAdapter.Repo("Repo 2", "Description 2"),
            RepoAdapter.Repo("Repo 3", "Description 3"),
        )

        // Post the sample data to LiveData
        _repoData.postValue(sampleData)
    }

}