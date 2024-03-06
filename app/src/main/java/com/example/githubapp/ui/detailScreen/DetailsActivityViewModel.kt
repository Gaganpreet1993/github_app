package com.example.githubapp.ui.detailScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.githubapp.domain.RepoDetailsInteractor
import com.example.githubapp.domain.RepoInteractor
import com.example.githubapp.domain.UserInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class DetailsActivityViewModel @Inject constructor(
    private val repoDetailsInteractor: RepoDetailsInteractor

) : ViewModel() {

    private val _forksCount = MutableLiveData<String>()
    val forksCount: LiveData<String> = _forksCount

    private val _repoDetails = MutableLiveData<String>()
    val repoDetails: LiveData<String> = _repoDetails

    private val _isStarBadge = MutableLiveData<Boolean>()
    val isStarBadge: LiveData<Boolean> = _isStarBadge

    fun fetchRepoDetails(userId: String, repoName: String) {
        val repoDetailsObservable = repoDetailsInteractor.getReposDetails(userId, repoName)
        repoDetailsObservable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
            .subscribe { repoDetails ->
                _repoDetails.postValue(
                    "Name: " + repoDetails.name + "\n" +
                            "Description: " + repoDetails.description + "\n" +
                            "Created At: " + repoDetails.createdAt + "\n" +
                            "Url: " + repoDetails.htmlUrl + "\n" +
                            "Language: " + repoDetails.language + "\n" +
                            "Open Issues Count: " + repoDetails.openIssuesCount + "\n" +
                            "Subscribers Count: " + repoDetails.subscribersCount
                )
                _forksCount.postValue("Forks: " + repoDetails.forks)
                _isStarBadge.postValue(if(repoDetails.forks>5000)true else false)

            }

    }

}