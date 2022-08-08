package com.bluemoon.privacyagreement

/**
 * Created by CHEN on 2022/8/8.
 */
open class PrivacyAgreementGradle {

    var enableDetect = false

    var methodOwner = ""
    var methodName = ""
    private val methodDesc = "(Ljava/lang/String;)V"

    fun transform() {
        if (methodOwner.isBlank() || methodName.isBlank()) {
            PrivacyAgreementConfig.runtimeRecord = null
        } else {
            PrivacyAgreementConfig.runtimeRecord = PrivacyRuntimeRecord(
                methodOwner = methodOwner.replace('.', '/'),
                methodName = methodName,
                methodDesc = methodDesc
            )
        }
    }
}