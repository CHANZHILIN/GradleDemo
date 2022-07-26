package com.bluemoon.detect64so.bit64.bean

/**
 * so包的实体信息
 * Created by CHEN on 2022/7/26.
 */
class SoFile {
    /**
     * 路径
     */
    var soPath: String = ""

    /**
     * 名字
     */
    var soName: String = ""

    /**
     * 引用的aar包的名字，如果没有则为“”
     */
    var pomName: String = ""

    override fun toString(): String {
        return StringBuilder().append("[")
            .append(pomName)
            .append(":")
            .append(soName)
            .append("]").toString()
    }

    override fun hashCode(): Int {
        return 31 * pomName.hashCode() + soName.hashCode()
    }

    override fun equals(other: Any?): Boolean {
        if (other !is SoFile) {
            return false
        }
        return pomName == other.pomName && soName == other.soName
    }
}