package com.bluemoon.detect64so.bit64.bean


/**
 * 维护各个架构的so列表
 * Created by CHEN on 2022/7/26.
 */
class SoFileList {

    val armeabi = mutableListOf<SoFile>()
    val armeabiv_v7a = mutableListOf<SoFile>()
    val arm64_v8a = mutableListOf<SoFile>()
    val x86 = mutableListOf<SoFile>()
    val x86_64 = mutableListOf<SoFile>()
    val mips = mutableListOf<SoFile>()
    val mips_64 = mutableListOf<SoFile>()

    /**
     * 打印结果信息
     */
    fun printlnResult() {
        println("Detect64so => armeabi size: ${armeabi.size}")
        printSoFileList(armeabi)
        println("Detect64so => armeabiv_v7a size: ${armeabiv_v7a.size}")
        printSoFileList(armeabiv_v7a)
        println("Detect64so => arm64_v8a size: ${arm64_v8a.size}")
        printSoFileList(arm64_v8a)
        println("Detect64so => x86 size: ${x86.size}")
        printSoFileList(x86)
        println("Detect64so => x86_64 size: ${x86_64.size}")
        printSoFileList(x86_64)
        println("Detect64so => mips size: ${mips.size}")
        printSoFileList(mips)
        println("Detect64so => mips_64 size: ${mips_64.size}")
        printSoFileList(mips_64)
        println("Detect64so => so in armeabi, but not in arm64-v8a:")
        diffSoFileList(armeabi, arm64_v8a)
        println("Detect64so => so in armeabiv-v7a, but not in arm64-v8a:")
        diffSoFileList(armeabiv_v7a, arm64_v8a)
        println("Detect64so => so in x86, but not in x86-64:")
        diffSoFileList(x86, x86_64)
        println("Detect64so => so in mips, but not in mips-64:")
        diffSoFileList(mips, mips_64)
    }

    /**
     * 差分比较不同
     */
    private fun diffSoFileList(so32List: List<SoFile>, so64List: List<SoFile>) {
        if (so32List.isEmpty()) {
            println()
            return
        }
        val so64Set = HashSet<SoFile>()
        so64List.forEach {
            so64Set.add(it)
        }
        var count = 0
        so32List.forEach { so32 ->
            if (!so64Set.contains(so32)) {
                count++
                println("Num-${count}:${so32.toString()}")
            }
        }
    }

    /**
     * 打印so文件列表
     */
    private fun printSoFileList(soList: List<SoFile>) {
        if (soList.isNotEmpty()) {
            var count = 0
            soList.forEach {
                count++
                println("Num-${count}:${it.toString()}")
            }
        }
    }

}