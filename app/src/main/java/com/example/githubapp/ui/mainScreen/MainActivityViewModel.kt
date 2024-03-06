package com.example.githubapp.ui.mainScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.githubapp.domain.RepoInteractor
import com.example.githubapp.domain.UserInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val userInteractor: UserInteractor,
    private val repoInteractor: RepoInteractor

) : ViewModel() {

    private val _repoData = MutableLiveData<List<RepoAdapter.Repo>>()
    val repoData: LiveData<List<RepoAdapter.Repo>> = _repoData

    private val _userName = MutableLiveData<String>()
    val userName: LiveData<String> = _userName

    private val _userPhoto = MutableLiveData<String>()
    val userPhoto: LiveData<String> = _userPhoto

    fun fetchUserInfo(userId: String) {
        val userDataObservable = userInteractor.getUsers(userId)
        userDataObservable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe{ userEntityList ->
            val user = userEntityList[0]
            _userName.postValue(user.login)
            _userPhoto.postValue(user.avatarUrl)
        }

    }
    fun fetchUserRepos(userId: String) {
        val repoDataObservable = repoInteractor.getRepos(userId)
        repoDataObservable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe{ repoEntityList ->
            val repoList = repoEntityList.map { RepoAdapter.Repo(it.name, it.description) }
            _repoData.postValue(repoList)
        }
    }

}