package com.example.root.shit.jobs;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.birbit.android.jobqueue.Job;
import com.birbit.android.jobqueue.Params;
import com.birbit.android.jobqueue.RetryConstraint;
import com.example.root.shit.events.CaptureEvent;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by root on 3/24/17.
 */

public class CaptureJob extends Job {

    Bitmap bitmap;

    public CaptureJob(Bitmap bitmap1) {

        super(new Params(1).requireNetwork());
        bitmap = bitmap1;

    }

    @Override
    public void onAdded() {

    }

    @Override
    public void onRun() throws Throwable {

        EventBus.getDefault().postSticky(new CaptureEvent(bitmap));
    }

    @Override
    protected void onCancel(int cancelReason, @Nullable Throwable throwable) {

    }

    @Override
    protected RetryConstraint shouldReRunOnThrowable(@NonNull Throwable throwable, int runCount, int maxRunCount) {
        return null;
    }
}
