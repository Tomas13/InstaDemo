package com.example.root.shit.events;

import android.graphics.Bitmap;

/**
 * Created by root on 3/24/17.
 */

public class CaptureEvent {
    private Bitmap bitmap;

    public CaptureEvent(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }
}
