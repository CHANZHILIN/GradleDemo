package com.bluemoon.gradledemo

import com.bluemoon.gradledemo.MyApplication.Companion.application
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

/**
 * 记录到手机的externalCacheDir
 * Created by CHEN on 2022/8/8.
 */
object PrivacyAgreementRecord {

    private val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS", Locale.CHINA)

    private val logFile = File(application.externalCacheDir, "PrivacyAgreement.txt")

    @JvmStatic
    fun writeToFile(log: String) {
        val time = simpleDateFormat.format(Date(System.currentTimeMillis()))
        val logFormat = "\n" + time + "\n" + log
        openOutputStream(logFile, true)?.write(
            logFormat.toByteArray()
        )

    }

    @Throws(IOException::class)
    fun openOutputStream(file: File, append: Boolean): FileOutputStream? {
        if (file.exists()) {
            if (file.isDirectory) {
                throw IOException("File '$file' exists but is a directory")
            }
            if (!file.canWrite()) {
                throw IOException("File '$file' cannot be written to")
            }
        } else {
            val parent = file.parentFile
            if (parent != null) {
                if (!parent.mkdirs() && !parent.isDirectory) {
                    throw IOException("Directory '$parent' could not be created")
                }
            }
        }
        return FileOutputStream(file, append)
    }
}