package com.cyl.musicapi.extractor

import java.net.URLDecoder
import java.util.*
import java.util.regex.Pattern


internal object Util {

    fun matchGroup1(pattern: String, input: String): String {
        return matchGroup(pattern, input, 1)
    }

    fun matchGroup(pattern: String, input: String, group: Int): String {
        val pat = Pattern.compile(pattern)
        val mat = pat.matcher(input)
        val foundMatch = mat.find()
        if (foundMatch) {
            return mat.group(group)
        } else {
            if (input.length > 1024) {
                throw Exception("failed to find pattern \"$pattern")
            } else {
                throw Exception("failed to find pattern \"$pattern inside of $input\"")
            }
        }
    }

    fun isMatch(pattern: String, input: String): Boolean {
        val pat = Pattern.compile(pattern)
        val mat = pat.matcher(input)
        return mat.find()
    }

    fun compatParseMap(input: String): Map<String, String> {
        val map = HashMap<String, String>()
        for (arg in input.split("&".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()) {
            val splitArg = arg.split("=".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            if (splitArg.size > 1) {
                map[splitArg[0]] = URLDecoder.decode(splitArg[1], "UTF-8")
            } else {
                map[splitArg[0]] = ""
            }
        }
        return map
    }
}