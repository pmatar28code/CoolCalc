package com.example.coolcalc

import android.widget.TextView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.TypeTextAction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CalculatorTest {
    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)
    @Test
    fun whenGivenAnOperationPressEqualsButtonAndShowResult(){
        onView(withId(R.id.textMultiInput)).perform(TypeTextAction("28+12-19x82/8x3-8+2/4"))
        var textView = activityRule.activity.findViewById<TextView>(R.id.textMultiInput)
        tempStringNumbers = textView.text.toString()
            onView(withId(R.id.buttonEquals))
            .perform(closeSoftKeyboard())
            .perform(ViewActions.click())
        onView(withText("159.9375")).check(matches(isDisplayed()))
    }
}