package com.example.githubapp.ui.mainScreen

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.githubapp.R
import com.example.githubapp.databinding.ActivityMainBinding
import com.example.githubapp.common.util.hideKeyboard
import com.example.githubapp.ui.detailScreen.DetailsActivity
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainActivityViewModel by viewModels()
    private lateinit var repoAdapter: RepoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        setUpUI()
        setUpListeners()
        setUpObservers()

    }

    private fun setUpObservers() {
        viewModel.repoData.observe(this) { repo ->
            if (repo.isNotEmpty()) {
                binding.repoRecyclerView.startAnimation(android.view.animation.AnimationUtils.loadAnimation(this@MainActivity,
                    R.anim.fade_in
                ))
                binding.repoRecyclerView.visibility = View.VISIBLE
                repoAdapter.setRepos(repo)
            }
        }
        viewModel.userName.observe(this) { name ->
            if(name.isNotEmpty()) {
                binding.profileName.startAnimation(android.view.animation.AnimationUtils.loadAnimation(this@MainActivity,
                    R.anim.fade_in
                ))
                binding.profileName.visibility = View.VISIBLE
                binding.profileName.text = name
            }
        }
        viewModel.userPhoto.observe(this) { imageUrl ->
            binding.profileImage.visibility = View.VISIBLE
            Picasso.get()
                .load(imageUrl)
                .fit()
                .centerCrop()
                .into(binding.profileImage, object : Callback {
                    override fun onSuccess() {
                        binding.profileImage.startAnimation(android.view.animation.AnimationUtils.loadAnimation(this@MainActivity,
                            R.anim.fade_in
                        ))
                    }
                    override fun onError(e: Exception?) {
                    }
                })
        }
    }

    private fun setUpListeners() {
        binding.searchButton.setOnClickListener {
            hideKeyboard(this)

            val userId = binding.editText.text.toString()
            viewModel.fetchUserInfo(userId)
            viewModel.fetchUserRepos(userId)
        }
    }

    private fun setUpUI() {
        repoAdapter = RepoAdapter {
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra("userName", viewModel.userName.value)
            intent.putExtra("repoName", it.name)
            startActivity(intent)
        }

        binding.repoRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.repoRecyclerView.adapter = repoAdapter
    }
}