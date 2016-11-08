package com.android.mobile.espresso;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import com.android.mobile.espresso.MainActivity;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
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

@LargeTest
@RunWith(AndroidJUnit4.class)
public class EspressoRecordingTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

//    @Before
//    public void setUp() {
//        checkoutFragment = new CheckoutFragment();
//        activityRule.getActivity().addFragment(checkoutFragment);
//    }

    @Test
    public void mainActivityTest2() {

        // Check first if the text views and buttons are visible.
        ViewInteraction button = onView(
                allOf(withId(R.id.test_click),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        button.check(matches(isDisplayed()));

        ViewInteraction button2 = onView(
                allOf(withId(R.id.test_click),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        button2.check(matches(isDisplayed()));

        // Compare the text of the textview before clicking the button.
        ViewInteraction textView2 = onView(
                allOf(withId(R.id.espresso_test), withText("Espresso Test"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                0),
                        isDisplayed()));
        textView2.check(matches(withText("Espresso Test")));

        // Perform the click of the button.
        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.test_click), withText("Test Click"), isDisplayed()));
        appCompatButton.perform(click());

        // Compare the text of the textview after clicking the button.
        ViewInteraction textView4 = onView(
                allOf(withId(R.id.espresso_test), withText("Button is clicked"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                0),
                        isDisplayed()));
        textView4.check(matches(withText("Button is clicked")));

        // Again perform the click of the button.
        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.test_click), withText("Test Click"), isDisplayed()));
        appCompatButton2.perform(click());

        // Compare the text of the textview again after clicking the button.
        ViewInteraction textView6 = onView(
                allOf(withId(R.id.espresso_test), withText("Espresso Test"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                0),
                        isDisplayed()));
        textView6.check(matches(withText("Espresso Test")));

    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
