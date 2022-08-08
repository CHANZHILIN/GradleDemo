package com.bluemoon.gradledemo

import android.os.Build
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

/**
 * Created by CHEN on 2022/8/8.
 */
object DeviceUtils {
    fun getBrand():String{
        return Build.BRAND
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