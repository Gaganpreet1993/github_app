package com.example.githubapp.ui.mainScreen


import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.idling.CountingIdlingResource
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.githubapp.R
import org.junit.Rule
import org.junit.Test

class AppUITest {

    @get:Rule
    var activityRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testUIFlow() {

        onView(withId(R.id.editText))
            .perform(typeText("octocat"))

        onView(withId(R.id.searchButton))
            .perform(click())

        val idlingResource = CountingIdlingResource("Delay", true)
        idlingResource.increment()
        Thread.sleep(2000)
        idlingResource.decrement()

        onView(withId(R.id.profileName)).check(matches(isDisplayed()))
        onView(withId(R.id.repoRecyclerView)).check(matches(isDisplayed()))

        }
}