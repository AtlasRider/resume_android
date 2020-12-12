package com.atlasrider.billdwyer

import android.app.Application
import android.util.Log

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "Application starting up")
    }

    companion object {
        private val TAG = MainApplication::class.java.simpleName
    }
}