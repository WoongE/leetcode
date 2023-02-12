package com.woonge.leetcode.p5

class Solution {
    fun longestPalindrome(s: String): String {
        if (s.length <= 1) return s

        for (length in IntRange(1, s.length).reversed()) {
            for (startIndex in IntRange(0, s.length - length)) {
                val endIndex = startIndex + length - 1
                if (isPalindrome(s, startIndex, endIndex)) {
                    return s.substring(startIndex, endIndex + 1)
                }
            }
        }
        return "${s[0]}"
    }

    private fun isPalindrome(s: String, startIndex: Int, endIndex: Int): Boolean {
        var si = startIndex
        var ei = endIndex
        while (si < ei) {
            if (s[si++] != s[ei--]) {
                return false
            }
        }
        return true
    }
}

fun main() {
    val solution = Solution()
    println(solution.longestPalindrome("babad"))
    println(solution.longestPalindrome("cbbd"))
    println(solution.longestPalindrome("b"))
    println(solution.longestPalindrome("abc"))
}
