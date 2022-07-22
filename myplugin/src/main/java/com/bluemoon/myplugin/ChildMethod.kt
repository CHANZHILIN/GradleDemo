package com.bluemoon.myplugin

import org.objectweb.asm.Label
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes
import org.objectweb.asm.commons.AdviceAdapter


/**
 * Created by CHEN on 2022/7/5.
 */
class ChildMethod(api: Int, methodVisitor: MethodVisitor?, access: Int, name: String?, descriptor: String?) :
    AdviceAdapter(
        api, methodVisitor, access,
        name,
        descriptor
    ), Opcodes {
    override fun visitCode() {
        super.visitCode()
    }

    override fun visitEnd() {
        super.visitEnd()
    }

    override fun onMethodEnter() {
        super.onMethodEnter()
    }

    override fun onMethodExit(opcode: Int) {
        super.onMethodExit(opcode)
        val label1 = Label()
        mv.visitLabel(label1)
        mv.visitLineNumber(10, label1)
        mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;")
        mv.visitLdcInsn("call--asm")
        mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false)


    }

    override fun visitInsn(opcode: Int) {
        super.visitInsn(opcode)
    }
}