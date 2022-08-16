package com.bluemoon.detectbigimage

import org.objectweb.asm.ClassVisitor
import org.objectweb.asm.Opcodes

/**
 * 替换ImageView的父类
 * Created by CHEN on 2022/8/16.
 */
class BigImageClassVisitor(private val config: BigImageGradleConfig, classVisitor: ClassVisitor?) :
    ClassVisitor(Opcodes.ASM9, classVisitor) {

    override fun visit(
        version: Int,
        access: Int,
        name: String?,
        signature: String?,
        superName: String?,
        interfaces: Array<out String>?
    ) {
        super.visit(
            version,
            access,
            name,
            signature,
            config.formatMonitorImageViewClass,//替换成配置的父类
            interfaces
        )
    }
}