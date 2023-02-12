package com.woonge.leetcode.p14

class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.size == 1) {
            return strs[0]
        }
        val firstStr = strs[0]
        var length = 0
        for ((ci, c) in firstStr.withIndex()) {
            for (si in IntRange(1, strs.size - 1)) {
                val cntStr = strs[si]
                if (cntStr.length <= ci || cntStr[ci] != c) {
                    return firstStr.take(length)
                }
            }
            length++
        }
        return firstStr.take(length)
    }
}

fun main() {
    val solution = Solution()
    println(solution.longestCommonPrefix(arrayOf("flower","flow","flight"))) // "fl"
    println(solution.longestCommonPrefix(arrayOf("dog","racecar","car"))) // ""
}