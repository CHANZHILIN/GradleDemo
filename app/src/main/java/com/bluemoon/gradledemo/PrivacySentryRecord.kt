package com.bluemoon.gradledemo

import com.bluemoon.gradledemo.MyApplication.Companion.application
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

object PrivacySentryRecord {

    private val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS", Locale.CHINA)

    val logFile = File(application.externalCacheDir, "PrivacySentry.txt")

    @JvmStatic
    fun writeToFile(log: String) {
        val time = simpleDateFormat.format(Date(System.currentTimeMillis()))
        val logFormat = "\n" + time + "\n" + log
        DeviceUtils.openOutputStream(logFile, true)?.write(
            logFormat.toByteArray()
        )

    }

}