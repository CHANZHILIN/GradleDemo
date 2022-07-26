package com.bluemoon.detect64so.extension

import groovy.lang.Closure
import org.gradle.api.Action
import org.gradle.api.Project
import org.gradle.util.internal.ConfigureUtil

/**
 * 拓展属性
 * Created by CHEN on 2022/7/26.
 */
open class Detect64Extension {
    var detect: Detect64soInfo = Detect64soInfo()
    fun detect(action: Action<Detect64soInfo>) {
        action.execute(detect)
    }

    fun detect(closure: Closure<Detect64soInfo>) {
        ConfigureUtil.configure(closure, detect)
    }

    companion object {
        // 将获取扩展对象的代码封装为静态方法
        fun getDetect64ExtensionConfig(project: Project): Detect64Extension {
            // 从 ExtensionContainer 容器获取扩展对象
            var extension = project.extensions.findByType(Detect64Extension::class.java)

            // 配置缺省的时候，赋予默认值
            if (null == extension) {
                extension = Detect64Extension()
            }
            return extension
        }
    }
}