package com.bluemoon.detect64so

import com.bluemoon.detect64so.bit64.Bit64Feature
import com.bluemoon.detect64so.extension.Detect64Extension
import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * 检测so包插件
 * Created by CHEN on 2022/7/26.
 */
class Detect64soPlugin : Plugin<Project> {

    companion object {
        val DETECT_64SO = "Detect64soPlugin"
    }

    override fun apply(project: Project) {
        // 1. Apply plugin extensions.
        applyExtension(project)
        // 2. Apply privacy features.
        applyFeature(project)
    }

    private fun applyExtension(project: Project) {
        project.extensions.create(DETECT_64SO, Detect64Extension::class.java)
    }


    private fun applyFeature(project: Project) {
        project.afterEvaluate {
            val detect64Extension = Detect64Extension.getDetect64ExtensionConfig(project)
            println(">>>CHEN>>> Detect =>enableDetect = ${detect64Extension.enableDetect}")
            //配置了enableDetect为ture,则执行新建Task
            if (detect64Extension.enableDetect) {
                Bit64Feature().apply(project)
            }
        }
    }
}