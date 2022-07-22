package com.bluemoon.myplugin

import org.objectweb.asm.ClassVisitor
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes


/**
 *  关键方法重写visitMethod方法
 *  匹配Child的call方法
 *  匹配到之后进去ChildMethod方法进行插桩
 * Created by CHEN on 2022/7/5.
 */
class ChildClassVisitor(classVisitor: ClassVisitor) : ClassVisitor(Opcodes.ASM9/*ASM的版本*/, classVisitor) {

    override fun visitMethod(
        access: Int,
        name: String?,  //方法名
        descriptor: String?,
        signature: String?,
        exceptions: Array<out String>?
    ): MethodVisitor {
        val methodVisitor = super.visitMethod(access, name, descriptor, signature, exceptions)
        //匹配到call方法
        if (name.equals("call")) {
            return ChildMethod(Opcodes.ASM9, methodVisitor, access, name, descriptor)
        }
        return methodVisitor
    }
}