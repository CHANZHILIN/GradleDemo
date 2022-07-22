package com.bluemoon.myplugin

import org.gradle.api.Project

/**
 * 扩展配置类
 * 是否启用asm
 * Created by CHEN on 2022/7/21.
 */
open class UseAsm {
    var useAsmToApplication: Boolean = false

    companion object {
        // 将获取扩展对象的代码封装为静态方法
        fun getConfig(project: Project): UseAsm {
            // 从 ExtensionContainer 容器获取扩展对象
            var extension = project.extensions.findByType(UseAsm::class.java)
            println(">>>CHEN>>> Config:project=${project.rootProject.name},extensionsList=${project.extensions},extension=${extension?.useAsmToApplication}")
            // 配置缺省的时候，赋予默认值
            if (null == extension) {
                extension = UseAsm()
            }
            return extension
        }
    }

}