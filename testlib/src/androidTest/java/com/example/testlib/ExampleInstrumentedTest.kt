package com.example.testlib

import androidx.test.espresso.Espresso
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.IdlingResource
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.testlib.activity.MainActivity
import com.example.testlib.uitest.idleresource.SimpleIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/***
 * IdleResources 的使用
 *  需要在生产代码中添加逻辑
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    var countingIdlingResource: IdlingResource? = null

    @Test
    fun useAppContext() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
    }

    @Rule
    @JvmField
    var mActivityRule: ActivityScenarioRule<MainActivity> = ActivityScenarioRule(
            MainActivity::class.java
    )

    @Before
    fun setup() {
        mActivityRule.scenario.onActivity {
            countingIdlingResource = SimpleIdlingResource()
            IdlingRegistry.getInstance().register(countingIdlingResource)
        }
    }

    @Test
    fun test() {
        Espresso.onView(ViewMatchers.withId(R.id.tv)).perform(ViewActions.click())
    }

    @After
    fun unregisterIdlingResource() {
        if (countingIdlingResource != null) {
            IdlingRegistry.getInstance().unregister(countingIdlingResource)
        }
    }


}