package com.bluemoon.myplugin

import groovy.lang.Closure
import org.gradle.api.Action
import org.gradle.api.Project
import org.gradle.util.internal.ConfigureUtil

/**
 * 扩展配置类
 * 是否启用asm
 * Created by CHEN on 2022/7/21.
 */
open class UseAsm {
    var useAsmToApplication: Boolean = false

    var useTryCatch: UseTryCatch = UseTryCatch()

    // 嵌套扩展闭包函数，方法名为 useTryCatch（方法名不一定需要与属性名一致）
    fun useTryCatch(action: Action<UseTryCatch>) {
        action.execute(useTryCatch)
    }
    // 嵌套扩展闭包函数，方法名为 useTryCatch
    fun useTryCatch(closure: Closure<UseTryCatch>) {
        ConfigureUtil.configure(closure, useTryCatch)
    }


    companion object {
        // 将获取扩展对象的代码封装为静态方法
        fun getConfig(project: Project): UseAsm {
            // 从 ExtensionContainer 容器获取扩展对象
            var extension = project.extensions.findByType(UseAsm::class.java)
            println(">>>CHEN>>> Config:project=${project.name},useAsmToApplication=${extension?.useAsmToApplication},uploadToService=${extension?.useTryCatch?.uploadToService}")
            // 配置缺省的时候，赋予默认值
            if (null == extension) {
                extension = UseAsm()
            }
            return extension
        }
    }

}