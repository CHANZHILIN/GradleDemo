package com.bluemoon.detectbigimage

import com.bluemoon.detectbigimage.utils.BaseTransform
import com.bluemoon.detectbigimage.utils.Log
import org.objectweb.asm.ClassReader
import org.objectweb.asm.ClassWriter

/**
 * Created by CHEN on 2022/8/16.
 */
class BigImageTransform(private val config: BigImageGradleConfig) : BaseTransform() {

    override fun modifyClass(byteArray: ByteArray): ByteArray {
        val classReader = ClassReader(byteArray)
        val className = classReader.className
        val superName = classReader.superName
        return if (className != config.formatMonitorImageViewClass && superName == "android/widget/ImageView") {
            Log.log("className: $className superName: $superName")
            val classWriter = ClassWriter(classReader, ClassWriter.COMPUTE_MAXS)
            val classVisitor = BigImageClassVisitor(config, classWriter)
            classReader.accept(classVisitor, ClassReader.EXPAND_FRAMES)
            classWriter.toByteArray()
        } else {
            byteArray
        }
    }
}