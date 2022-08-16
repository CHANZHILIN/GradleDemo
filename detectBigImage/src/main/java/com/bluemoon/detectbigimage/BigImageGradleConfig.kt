package com.bluemoon.detectbigimage

import org.gradle.api.Project

/**
 * Created by CHEN on 2022/8/8.
 */
open class BigImageGradleConfig {

    var enableBigImageDetect = false

    /**
     * 替换的监控父类
     */
    var monitorImageViewClass: String? = null

    companion object {
        // 将获取扩展对象的代码封装为静态方法
        fun getGradleConfig(project: Project): BigImageGradleConfig {
            // 从 ExtensionContainer 容器获取扩展对象
            var extension = project.extensions.findByType(BigImageGradleConfig::class.java)

            // 配置缺省的时候，赋予默认值
            if (null == extension) {
                extension = BigImageGradleConfig()
            }
            return extension
        }
    }

    val formatMonitorImageViewClass: String?
        get() = monitorImageViewClass?.replace(".", "/")
}