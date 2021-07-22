package com.dynamicdevz.dynamicsecondlast

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test

class MainActivityTest {

    val input = "kendy occean to be capitalized"


    @JvmField
    @Rule
    val testRule = ActivityTestRule(MainActivity::class.java)

//    @get: Rule
//    val activityScenario: ActivityScenario<MainActivity> = ActivityScenario.launch(MainActivity::class.java)

    @Test
    fun testCorrectInput() {
        Espresso.onView(withId(R.id.input_edittext)).perform(ViewActions.typeText(input))
        Espresso.onView(withId(R.id.input_edittext)).check(matches(withText(input)))
    }

    @Test
    fun testButtonClick() {
        Espresso.onView(withId(R.id.input_edittext)).perform(ViewActions.typeText(input))
        Espresso.closeSoftKeyboard()
        Espresso.onView(withId(R.id.submit_button)).perform(click())
    }

    @Test
    fun testOpenActivity() {
        Espresso.onView(withId(R.id.input_edittext)).perform(typeText(input))
        Espresso.closeSoftKeyboard()
        Espresso.onView(withId(R.id.submit_button)).perform(click())
        Espresso.onView(withId(R.id.output_textview)).check(ViewAssertions.matches(isDisplayed()))
    }

    @Test
    fun testPassData(){
        Espresso.onView(withId(R.id.input_edittext)).perform(typeText(input))
        Espresso.closeSoftKeyboard()
        Thread.sleep(3000)
        Espresso.onView(withId(R.id.submit_button)).perform(click())
        Espresso.onView(withId(R.id.output_textview)).check(ViewAssertions.matches(isDisplayed()))
        Espresso.onView(withId(R.id.output_textview)).check(matches(withText(input.uppercase())))
    }

}