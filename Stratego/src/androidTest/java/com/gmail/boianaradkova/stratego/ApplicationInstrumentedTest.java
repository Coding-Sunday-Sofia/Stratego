package com.gmail.boianaradkova.stratego;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test of the board activity.
 *
 * @author Boyana Kantarska
 */
@RunWith(AndroidJUnit4.class)
public class ApplicationInstrumentedTest {
    @Test
    public void useApplicaitonContext() {
        Context appContext = InstrumentationRegistry.getTargetContext();
        assertEquals("com.gmail.boianaradkova.stratego", appContext.getPackageName());
    }
}
