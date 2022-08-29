package com.bluemoon.configplugin

import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * Created by CHEN on 2022/8/23.
 */
class ConfigPlugin : Plugin<Project> {

    companion object {
        val CONFIG_PLUGIN = "ConfigPlugin"
    }


    override fun apply(project: Project) {
        // 1. Apply plugin extensions.
        applyExtension(project)
    }

    private fun applyExtension(project: Project) {
        project.extensions.create(CONFIG_PLUGIN, ConfigGradle::class.java)
    }
}