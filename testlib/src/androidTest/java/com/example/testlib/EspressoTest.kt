package com.example.testlib

import android.graphics.ColorSpace.match
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.testlib.activity.MainActivity
import org.hamcrest.core.AllOf.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class EspressoTest {

    @Test
    fun useAppContext() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
    }

    @Rule
    @JvmField
    var mActivityRule: ActivityScenarioRule<MainActivity> = ActivityScenarioRule(
            MainActivity::class.java
    )

    @Test
    fun test_input() {
        onView(withId(R.id.et_text)).perform(typeText("123456")).check(matches(isDisplayed()))
    }

    @Test
    fun test_click() {
        onView(allOf(withId(R.id.tv),withText("ID:TV"))).perform(click())
    }
}