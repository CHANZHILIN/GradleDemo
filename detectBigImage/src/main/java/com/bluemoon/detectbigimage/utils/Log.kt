package com.bluemoon.detectbigimage.utils

import java.util.concurrent.Executors

/**
 * Created by CHEN on 2022/8/8.
 */
object Log {

    private val logThreadExecutor = Executors.newSingleThreadExecutor()

    fun log(log: Any?) {
        logThreadExecutor.submit {
            println(">>>CHEN>>> BigImageDetected: $log")
        }
    }

}