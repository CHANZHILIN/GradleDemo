package com.bluemoon.detectbigimage

import com.android.build.gradle.AppExtension
import com.bluemoon.detectbigimage.utils.Log
import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * 检测大图插件
 * Created by CHEN on 2022/8/16.
 */
class DetectBigImagePlugin : Plugin<Project> {
    companion object {
        const val DETECT_BIG_IMAGE = "DetectBigImagePlugin"
    }

    override fun apply(project: Project) {
        // 1. Apply plugin extensions.
        applyExtension(project)
        // 2. Apply privacy features.
        applyFeature(project)

    }

    private fun applyExtension(project: Project) {
        project.extensions.create(DETECT_BIG_IMAGE, BigImageGradleConfig::class.java)
    }


    private fun applyFeature(project: Project) {
        project.afterEvaluate {
            val config = BigImageGradleConfig.getGradleConfig(project)
            Log.log("DetectBigImagePlugin =>enableBigImageDetect = ${config.enableBigImageDetect},monitorImageViewClass=${config.monitorImageViewClass}")
            if (config.enableBigImageDetect) {

            }
        }

        val appExtension = project.extensions.getByType(AppExtension::class.java)
        appExtension.registerTransform(BigImageTransform(BigImageGradleConfig.getGradleConfig(project)))
    }
}