package com.example.githubapp.ui.detailScreen

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.githubapp.R
import com.example.githubapp.databinding.ActivityMainBinding
import com.example.githubapp.common.util.hideKeyboard
import com.example.githubapp.databinding.ActivityDetailsBinding
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding
    private val viewModel: DetailsActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailsBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        supportActionBar?.setBackgroundDrawable(ColorDrawable(getResources().getColor(R.color.colorPrimary)))

        setUpObservers()
        val repoName = intent.getStringExtra("repoName") ?: ""
        val userName = intent.getStringExtra("userName") ?: ""

        viewModel.fetchRepoDetails(userName, repoName)

    }

    private fun setUpObservers() {
        viewModel.repoDetails.observe(this) { repoDetails ->
            if (repoDetails.isNotEmpty()) {
               binding.repoDetails.text = repoDetails
            }
        }
        viewModel.forksCount.observe(this) { forkCount ->
            if(forkCount.isNotEmpty()) {
                binding.forksCount.text = forkCount
            }
        }
        viewModel.isStarBadge.observe(this) { isStarBadge ->
            if(isStarBadge) {
                binding.forksCount.setTextColor(Color.RED)
                binding.starBadge.visibility = View.VISIBLE
            }
        }
    }

}