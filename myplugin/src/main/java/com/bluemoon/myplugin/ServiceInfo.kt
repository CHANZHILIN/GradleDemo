package com.bluemoon.myplugin

/**
 * 环境信息
 * Created by CHEN on 2022/7/25.
 */
class ServiceInfo(private val name: String) {
    var url: String? = null
    override fun toString(): String {
        return "name = ${name},url = ${url}"
    }
}