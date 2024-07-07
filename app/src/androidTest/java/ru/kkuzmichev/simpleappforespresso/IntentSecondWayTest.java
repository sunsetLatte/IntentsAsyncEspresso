package ru.kkuzmichev.simpleappforespresso;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasData;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import android.content.Intent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.intent.Intents;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;


public class IntentSecondWayTest {

    @Rule
    public ActivityScenarioRule<MainActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);


        @Test
    public void testGoToSettings() {
        ViewInteraction overflowMenuButton = onView(withContentDescription("Ещё"));
        overflowMenuButton.check(matches(isDisplayed()));
        overflowMenuButton.perform(click());
        ViewInteraction settings = onView(allOf(withId(R.id.title), withText("Settings")));
        settings.check(matches(isDisplayed()));
        Intents.init();
        settings.perform(click());
        intended(hasData("https://google.com"));
        intended(hasAction(Intent.ACTION_VIEW));
        Intents.release();
    }
}
