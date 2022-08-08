package com.bluemoon.gradledemo

import android.app.Application

/**
 * Created by CHEN on 2022/8/8.
 */
class MyApplication : Application() {
    companion object {
        lateinit var application: MyApplication
            private set
    }

    override fun onCreate() {
        super.onCreate()
        application = this
    }
}