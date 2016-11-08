package com.android.espresso;

import android.content.Intent;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import espresso.mobile.staples.com.librarytest.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@RunWith(AndroidJUnit4.class)
public class EspressoTestingWithLibrary {

    @Rule
    public ActivityTestRule<TestActivity> activityRule = new ActivityTestRule<>(TestActivity.class);

    @Before
    public void setUp() {

        Intent intent = new Intent();
        activityRule.launchActivity(intent);
    }

    @Test
    public void testUI() throws Exception {

        // Check if the target view is displayed and has expected text on it.
        onView(withId(R.id.espresso_test)).check(matches(allOf(withText("Espresso Test"), isDisplayed())));

        // Check if the button is visible.
        onView(withId(R.id.test_click)).check(matches(isDisplayed()));

    }
}
