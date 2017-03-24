package com.example.root.shit;

import android.app.Application;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by root on 3/17/17.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        AppJobManager.getJobManager(this);


        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/sherlocked.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }
}
