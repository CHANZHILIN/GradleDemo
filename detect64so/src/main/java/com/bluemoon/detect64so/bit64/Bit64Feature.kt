package com.bluemoon.detect64so.bit64

import com.bluemoon.detect64so.bit64.bean.SoFile
import com.bluemoon.detect64so.bit64.bean.SoFileList
import org.gradle.api.Project
import org.gradle.api.Task
import java.io.File

/**
 * 实际处理检索app中的so包
 * Created by CHEN on 2022/7/26.
 */
class Bit64Feature {
    fun apply(project: Project) {
        project.afterEvaluate {
            var mergeNativeTask: Task? = null
            //获取到> Task :app:mergeReleaseNativeLibs 合并的Task，基于这个task作业
            project.tasks.forEach {
                if (it.name.startsWith("merge") && it.name.endsWith("NativeLibs")) {
                    mergeNativeTask = it
                }
            }
            mergeNativeTask?.let { mergeTask ->
                //创建一个名为support64BitAbi的task,在app->Tasks->detect64BitAbi->support64BitAbi
                project.tasks.create("support64BitAbi") { task ->
                    task.apply {
                        group = "detect64BitAbi"
                        dependsOn(mergeTask)
                        doFirst {
                            println("===================================Detect64so => Support 64-bit abi start=======================================")
                            val soList = SoFileList()
                            mergeTask.inputs.files.forEach { file ->
                                findSoFile(file, soList)
                            }
                            soList.printlnResult()
                            println("===================================Detect64so => Support 64-bit abi end=======================================")

                        }
                    }
                }
            }
        }
    }

    /**
     * 查找so文件
     */
    private fun findSoFile(file: File?, soList: SoFileList) {
        if (file == null) {
            return
        }
        if (file.isDirectory) {
            file.listFiles()?.forEach {
                //文件夹 回归遍历
                findSoFile(it, soList)
            }
        } else if (file.absolutePath.endsWith(".so")) {
            //将符合条件的so分别加入维护的列表中
            println("Detect64so => so package absolutePath: ${file.absolutePath}")
            val so: SoFile = generateSoInfo(file)
            if (so.soPath.contains("armeabi-v7a")) {
                soList.armeabiv_v7a.add(so)
            } else if (so.soPath.contains("armeabi")) {
                soList.armeabi.add(so)
            } else if (so.soPath.contains("arm64-v8a")) {
                soList.arm64_v8a.add(so)
            } else if (so.soPath.contains("x86_64")) {
                soList.x86_64.add(so)
            } else if (so.soPath.contains("x86")) {
                soList.x86.add(so)
            } else if (so.soPath.contains("mips64")) {
                soList.mips_64.add(so)
            } else if (so.soPath.contains("mips")) {
                soList.mips.add(so)
            }
        }
    }

    /**
     * 获取解析so包的信息
     * Detect64so => so package absolutePath: C:\Users\Admin\.gradle\caches\transforms-3\6153b3511841ed5300b9521806d8ffcd\transformed\openDefault-4.2.7\jni\x86\libweibosdkcore.so
     * Detect64so => so package absolutePath: D:\Source\GradleDemo\app\build\intermediates\merged_jni_libs\release\out\arm64-v8a\libgetuiext3.so
     */
    private fun generateSoInfo(file: File): SoFile {
        val filePath = file.absolutePath
        val so = SoFile().apply {
            soPath = filePath
            soName = file.name
        }
        //不处于aar包引用
        if (filePath.contains("merged_jni_libs") || filePath.contains("library_jni")) {
            so.pomName = ""
        } else {
            var separator = File.separator
            if (filePath.contains("\\\\")) {
                separator = "\\\\"
            }
            /*if (System.getProperty("os.name").lowercase().contains("windows")) {
                separator = "\\\\"
            }*/
            val dirPath = filePath.split(separator)
            //取倒数第4位即为aar的名字
            so.pomName = dirPath[dirPath.size - 4]
        }
        return so
    }
}