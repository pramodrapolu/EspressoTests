package com.staples.mobile.espresso;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@RunWith(AndroidJUnit4.class)
public class EspressoManualTest {

    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testUI() throws Exception {

        // Check if the target view is displayed and has expected text on it.
        onView(withId(R.id.espresso_test)).check(matches(allOf(withText("Espresso Test"), isDisplayed())));

        // Check if the button is visible.
        onView(withId(R.id.test_click)).check(matches(isDisplayed()));

        // Check the text of the textView.
        onView(withId(R.id.espresso_test)).check(matches(withText("Espresso Test")));

        // Perform Click on the button.
        onView(withId(R.id.test_click)).perform(click());

        // Check if the text of that textView is changed.
        onView(withId(R.id.espresso_test)).check(matches(withText("Button is clicked")));

        // Again Perform Click.
        onView(withId(R.id.test_click)).perform(click());

        // Check the text on the textView if the text is changed.
        onView(withId(R.id.espresso_test)).check(matches(withText("Espresso Test")));

    }
}
