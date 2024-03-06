# GitHub User Explorer Android App

This Android application allows users to explore GitHub users, view their repositories, and get details about specific repositories. It communicates with the public GitHub API to fetch user information and repository data.

## Features

- Accepts a GitHub user's ID as input and displays the user's avatar and name.
- Shows a scrollable list of public repositories owned by the user, displaying repository name and description.
- Provides a detail screen for each selected repository, displaying detailed information about the repository.
- Implements a star badge for repositories with more than 5000 forks.
- Utilizes the following technologies:
  - MVVM architecture
  - Modular Design
  - Dagger Hilt for dependency injection
  - Unit tests and UI tests for robustness
  - Retrofit for API calls with Kotlin coroutines for asynchronous programming
  - Gradle version catalog (.toml)

## API Base URL

This application is based on the GitHub API with the base URL `https://api.github.com/`, utilizing the following routes:

1. `/search/users` - Endpoint for searching GitHub users.
2. `/users/{login}/repos` - Endpoint for fetching repositories of a specific GitHub user.
3. `/repos/{owner}/{repo}` - Endpoint for getting details about a specific repository.

[githubapp.webm](https://github.com/Gaganpreet1993/github_app/assets/5916001/427ecfd1-5193-4fcd-84bb-c25642e12ab5)

You can download the APK here

[githubapp.zip](https://github.com/Gaganpreet1993/github_app/files/14504291/githubapp.zip)
