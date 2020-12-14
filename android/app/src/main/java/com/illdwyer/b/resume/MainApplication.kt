package com.illdwyer.b.resume

import android.app.Application
import android.util.Log

@Suppress("unused")
class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "Application starting up")
    }

    companion object {
        private val TAG = MainApplication::class.java.simpleName
    }
}