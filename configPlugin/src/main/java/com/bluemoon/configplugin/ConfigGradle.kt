package com.bluemoon.configplugin

import org.gradle.api.Project

/**
 * 拓展属性
 * Created by CHEN on 2022/7/26.
 */
open class ConfigGradle {

    var enableConfig = false

    companion object {
        // 将获取扩展对象的代码封装为静态方法
        fun getConfigGradle(project: Project): ConfigGradle {
            // 从 ExtensionContainer 容器获取扩展对象
            var extension = project.extensions.findByType(ConfigGradle::class.java)

            // 配置缺省的时候，赋予默认值
            if (null == extension) {
                extension = ConfigGradle()
            }
            return extension
        }
    }
}