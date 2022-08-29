package com.bluemoon.configplugin

/**
 * 第三方依赖管理
 * Created by CHEN on 2022/8/23.
 */
object BuildVersions {
    const val minSdkVersion = 23
    const val targetSdkVersion = 26
    const val compileSdkVersion = 31
    const val buildToolsVersion = "31.0.0"
}

object Versions {
    const val glideVersion = "4.13.2"
    const val smartRefreshVersion = "2.0.5"
    const val okdownloadVersion = "1.0.7"
    const val retrofitVersion = "2.9.0"
    const val okhttpVersion = "4.10.0"
    const val roomVersion = "2.4.3"
    const val kotlin_version = "1.7.10"
    const val hiltVersion = "2.43"
}

object Deps {
    // 监控
    const val leakcanary = "com.squareup.leakcanary:leakcanary-android:2.9.1"
    // const val leakcanary_process = "com.squareup.leakcanary:leakcanary-android-process:2.8.1"

    // bluemoon
    // 友盟崩溃分析、友盟统计、友盟分享
    // 包含了okhttp，务必一致
    const val lib_umeng = "com.bluemoon.umengshare:lib_umengshare:1.4.9"

    // x5包含xxpermission，务必一致
    const val lib_x5 = "com.bluemoon.x5:lib_x5:1.10.82"
    const val lib_hotfix = "com.bluemoon.hotfix:lib_hotfix:1.0.17"
    const val lib_encrypt = "com.bluemoon.encrypt:lib_encrypt:1.1.2"
    const val lib_ffmpeglibrary = "com.bluemoon.ffmpeg:FFmpegLibrary:1.2.8"

    //network
    const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttpVersion}"
    const val logging_interceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttpVersion}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
    const val retrofit_converter_gson = "com.squareup.retrofit2:converter-gson:${Versions.retrofitVersion}"
    const val retrofit_url_manager = "me.jessyan:retrofit-url-manager:1.4.0"

    // view
    const val smart_refresh_layout = "io.github.scwang90:refresh-layout-kernel:${Versions.smartRefreshVersion}"
    const val smart_refresh_header = "io.github.scwang90:refresh-header-classics:${Versions.smartRefreshVersion}"
    const val smart_refresh_footer = "io.github.scwang90:refresh-footer-classics:${Versions.smartRefreshVersion}"
    const val BaseRecyclerViewAdapterHelper = "com.github.CymChad:BaseRecyclerViewAdapterHelper:3.0.7"
    const val lottie = "com.airbnb.android:lottie:5.0.2"
    const val autosize = "me.jessyan:autosize:1.2.1"
    const val roundedimageview = "com.makeramen:roundedimageview:2.3.0"

    // kotlin
    const val kotlin_stdlib_jdk7 = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin_version}"
    const val kotlinx_coroutines_android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4"

    //jetpack
    const val multidex = "androidx.multidex:multidex:2.0.1"

    // const val lifecycle_extensions = "androidx.lifecycle:lifecycle-extensions:2.2.0"   //已弃用
    const val lifecycle_viewmodel_ktx = "androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.1"
    const val lifecycle_livedata_ktx = "androidx.lifecycle:lifecycle-livedata-ktx:2.5.1"

    const val fragment = "androidx.fragment:fragment:1.5.1"
    const val lifecycle_fragment_ktx = "androidx.fragment:fragment-ktx:1.5.1"

    const val appcompat = "androidx.appcompat:appcompat:1.4.2"
    const val constraint_layout = "androidx.constraintlayout:constraintlayout:2.1.4"
    const val recyclerview_v7 = "androidx.recyclerview:recyclerview:1.2.1"
    const val design = "com.google.android.material:material:1.6.1"
    const val support_v4 = "androidx.legacy:legacy-support-v4:1.0.0"
    const val cardview_v7 = "androidx.cardview:cardview:1.0.0"

    // Hilt
    const val hilt_android = "com.google.dagger:hilt-android:${Versions.hiltVersion}"
    const val hilt_android_compiler = "com.google.dagger:hilt-android-compiler:${Versions.hiltVersion}"

    // tools
    const val bugly = "com.tencent.bugly:crashreport:4.0.4"
    const val onelogin = "com.geetest.android:onelogin:2.7.7"
    const val mmkv = "com.tencent:mmkv-static:1.2.13"
    const val gson = "com.google.code.gson:gson:2.9.0"
    const val arouter = "com.alibaba:arouter-api:1.5.2"
    const val arouter_compiler = "com.alibaba:arouter-compiler:1.5.2"
    const val xxpermissions = "com.github.getActivity:XXPermissions:15.0"
    const val eventbus = "org.greenrobot:eventbus:3.3.1"
    const val logger = "com.orhanobut:logger:2.2.0"

    const val uinspector = "com.huya.mobile:Uinspector:1.0.11"

    const val glide = "com.github.bumptech.glide:glide:${Versions.glideVersion}"
    const val glide_compiler = "com.github.bumptech.glide:compiler:${Versions.glideVersion}"
    const val glide_loader_okhttp3 = "com.github.bumptech.glide:okhttp3-integration:${Versions.glideVersion}"

    const val okdownload_core = "com.liulishuo.okdownload:okdownload:${Versions.okdownloadVersion}"
    const val okdownload_sqlite = "com.liulishuo.okdownload:sqlite:${Versions.okdownloadVersion}"
    const val okdownload_okhttp = "com.liulishuo.okdownload:okhttp:${Versions.okdownloadVersion}"
    const val okdownload_filedownloader = "com.liulishuo.okdownload:filedownloader:${Versions.okdownloadVersion}"
    const val okdownload_ktx = "com.liulishuo.okdownload:ktx:${Versions.okdownloadVersion}"

    // room
    const val room_runtime = "androidx.room:room-runtime:${Versions.roomVersion}"
    const val room_compiler = "androidx.room:room-compiler:${Versions.roomVersion}"
    const val room_ktx = "androidx.room:room-ktx:${Versions.roomVersion}"

    //test
    const val junit = "junit:junit:4.13.2"
    const val runner = "com.android.support.test:runner:1.0.2"
    const val ext_junit = "androidx.test.ext:junit:1.1.3"
    const val espresso_core = "androidx.test.espresso:espresso-core:3.4.0"
    const val espresso_idling = "androidx.test.espresso:espresso-idling-resource:3.4.0"
    const val rules = "androidx.test:rules:1.4.0"
    const val core_ktx = "androidx.test:core-ktx:1.4.0"
    const val espresso_contrib = "com.android.support.test.espresso:espresso-contrib:2.0"    //用于Recyclerview测试

    // const val espresso_intents = "com.android.support.test.espresso:espresso-intents:3.0.2"  //activity跳转测试
    const val okhttp3_idling_resource = "com.jakewharton.espresso:okhttp3-idling-resource:1.0.0"
    const val espresso_web = "com.android.support.test.espresso:espresso-web:3.1.0"  //web交互测试

    // react native
    const val react_native = "com.facebook.react:react-native:+" // From node_modules
    const val jsc = "corg.webkit:android-jsc:+" // From node_modules

    /**
     * 小屋专属
     */
    object BlueHouse {
        const val kefu_sdk_lite = "com.easemob:kefu-sdk-lite:1.3.1" ///1.3.1

        const val lib_idcardocr = "com.bluemoon.lib_idcardocr:lib_idcardocr:1.0.2"   //身份证识别
        const val lib_widget = "com.bluemoon.widget:lib_widget:1.2.5"
        const val lib_qrcode = "com.bluemoon.util:lib_barcode:2.2.5"
        const val lib_badger = "com.bluemoon.badger:lib_badger:0.0.3"
        const val lib_gaode_map = "com.bluemoon.map:lib_map:1.0.6"
        const val lib_pulltorefresh = "com.bluemoon.widget:lib_pulltorefresh:1.0.2"

        const val android_async_http = "com.loopj.android:android-async-http:1.4.11"
        const val compressor = "id.zelory:compressor:3.0.1"


        const val banner = "io.github.youth5201314:banner:2.2.2"
        const val jiaozivideoplayer = "cn.jzvd:jiaozivideoplayer:7.7.2.3300"
        const val calendarview = "com.haibin:calendarview:3.7.1"
        const val videocache = "com.danikula:videocache:2.7.1"
        const val autofittextview = "me.grantland:autofittextview:0.2.1"
        const val android_pickerView = "com.contrarywind:Android-PickerView:4.1.9"
        const val swipe_del_menu_layout = "com.github.mcxtzhang:SwipeDelMenuLayout:V1.3.0"

        const val butterknife = "com.jakewharton:butterknife:10.2.3"
        const val butterknife_compiler = "com.jakewharton:butterknife-compiler:10.2.3"

        const val flex_box = "com.google.android.flexbox:flexbox:3.0.0"

        const val android_gif_drawable = "pl.droidsonroids.gif:android-gif-drawable:1.2.24"

        const val picture_selector = "io.github.lucksiege:pictureselector:v3.10.3"   //图片选择
        const val picture_ucrop = "io.github.lucksiege:ucrop:v3.10.2"   //图片选择 裁剪
    }
}
