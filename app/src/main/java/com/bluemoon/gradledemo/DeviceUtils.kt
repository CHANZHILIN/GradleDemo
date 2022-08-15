package com.bluemoon.gradledemo

import android.os.Build
import java.io.ByteArrayOutputStream
import java.io.PrintStream

/**
 * Created by CHEN on 2022/8/8.
 */
object DeviceUtils {
    fun getBrand(): String {
        val methodDesc = "xxx"
        writeToFile(methodDesc,Throwable())
        return Build.BRAND
    }

    private fun writeToFile(log: String, throwable: Throwable) {
        val byteArrayOutputStream = ByteArrayOutputStream()
        throwable.printStackTrace(PrintStream(byteArrayOutputStream))
        val stackTrace = byteArrayOutputStream.toString()
        val realLog = log + stackTrace
        //将 realLog 写入到文本中
        PrivacyAgreementRecord.writeToFile(realLog)
    }

}