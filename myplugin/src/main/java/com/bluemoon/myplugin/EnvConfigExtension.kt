package com.bluemoon.myplugin

import groovy.lang.Closure
import org.gradle.api.Action
import org.gradle.api.NamedDomainObjectContainer
import org.gradle.api.Project
import org.gradle.util.internal.ConfigureUtil

/**
 * 环境配置拓展
 * Created by CHEN on 2022/7/25.
 */
open class EnvConfigExtension(project: Project) {
    var services: NamedDomainObjectContainer<ServiceInfo> = project.container(ServiceInfo::class.java)


    fun services(action: Action<NamedDomainObjectContainer<ServiceInfo>>) {
        action.execute(services)
    }

    fun services(closure: Closure<NamedDomainObjectContainer<ServiceInfo>>) {
        ConfigureUtil.configure(closure, services)
    }

    companion object {
        // 将获取扩展对象的代码封装为静态方法
        fun getNamedDomainExtensionConfig(project: Project): EnvConfigExtension {
            // 从 ExtensionContainer 容器获取扩展对象
            var extension = project.extensions.findByType(EnvConfigExtension::class.java)

            // 配置缺省的时候，赋予默认值
            if (null == extension) {
                extension = EnvConfigExtension(project)
            }
            return extension
        }
    }
}