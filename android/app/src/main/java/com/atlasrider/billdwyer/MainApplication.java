package com.atlasrider.billdwyer;

import android.app.Application;
import android.util.Log;

public class MainApplication extends Application {
    private static String TAG = MainApplication.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "Application starting up");
    }
}
