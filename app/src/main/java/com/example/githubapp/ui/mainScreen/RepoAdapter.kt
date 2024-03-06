package com.example.githubapp.ui.mainScreen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.githubapp.databinding.ItemRepoBinding

class RepoAdapter(private val onItemClick: (Repo) -> Unit) : RecyclerView.Adapter<RepoAdapter.RepoViewHolder>() {

    private var repos: List<Repo> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        val binding = ItemRepoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RepoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        val repo = repos[position]
        holder.binding.repoName.text = repo.name
        holder.binding.repoDescription.text = repo.description
        holder.itemView.setOnClickListener {
           onItemClick(repo)
        }
    }

    override fun getItemCount(): Int {
        return repos.size
    }

    fun setRepos(repos: List<Repo>) {
        this.repos = repos
        notifyDataSetChanged()
    }

    data class Repo(
        val name: String,
        val description: String?
    )
    inner class RepoViewHolder(val binding: ItemRepoBinding) : RecyclerView.ViewHolder(binding.root)

}
