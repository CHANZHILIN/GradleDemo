package com.bluemoon.privacyagreement

import com.android.build.gradle.AppExtension
import com.bluemoon.privacyagreement.utils.Log
import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * Created by CHEN on 2022/8/8.
 */
class PrivacyDetectPlugin : Plugin<Project> {
    companion object {
        const val PRIVACY_DETECT = "privacyDetect"
    }

    override fun apply(project: Project) {
        // 1. Apply plugin extensions.
        applyExtension(project)
        // 2. Apply privacy features.
        applyFeature(project)
    }

    private fun applyExtension(project: Project) {
        project.extensions.create(PRIVACY_DETECT, PrivacyAgreementGradle::class.java)
    }

    private fun applyFeature(project: Project) {
        project.afterEvaluate {
            val config =
                (it.extensions.findByName(PRIVACY_DETECT) as? PrivacyAgreementGradle) ?: PrivacyAgreementGradle()
            Log.log("privacyDetect =>enableDetect = ${config.enableDetect}")
            if (config.enableDetect) {
                config.transform()
            }
        }
        val appExtension: AppExtension = project.extensions.getByType(AppExtension::class.java)
        appExtension.registerTransform(PrivacyTransform(config = PrivacyAgreementConfig()))
    }
}