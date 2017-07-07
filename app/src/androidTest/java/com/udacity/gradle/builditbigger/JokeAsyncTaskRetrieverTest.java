package com.udacity.gradle.builditbigger;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.v4.util.Pair;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertTrue;

/**
 * Created by denis on 07.07.2017.
 */
@RunWith(AndroidJUnit4.class)
public class JokeAsyncTaskRetrieverTest implements ProgressBarVisibilityHandler {

    @Test
    public void testNonEmptyString() {
        EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask(this);

        endpointsAsyncTask.execute(new Pair<>(InstrumentationRegistry.getTargetContext(), "test"));

        String result = "";
        try {
            result = endpointsAsyncTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        assertTrue(result.length() > 0);
    }

    @Override
    public void showProgressBar() {

    }

    @Override
    public void hideProgressBar() {

    }
}
