package com.bluemoon.privacyagreement

/**
 * Created by CHEN on 2022/8/8.
 */
data class PrivacyAgreementConfig(
    val fieldHookPointList: List<PrivacyHookPoint> = filedHookPoints,
    val methodHookPointList: List<PrivacyHookPoint> = methodHookPoints,
) {
    companion object {
        var runtimeRecord: PrivacyRuntimeRecord? = null
    }
}

private val methodHookPoints = listOf(
    PrivacyHookPoint(
        owner = "android/telephony/TelephonyManager",
        name = "getDeviceId",
        desc = "()Ljava/lang/String;"
    ),
)

private val filedHookPoints = listOf(
    PrivacyHookPoint(
        owner = "android/os/Build",
        name = "BRAND",
        desc = "Ljava/lang/String;"
    ),
)

data class PrivacyHookPoint(
    val owner: String,
    val name: String,
    val desc: String
)

data class PrivacyRuntimeRecord(
    val methodOwner: String,
    val methodName: String,
    val methodDesc: String
)