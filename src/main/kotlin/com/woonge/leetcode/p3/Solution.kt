package com.woonge.leetcode.p3

import kotlin.math.max

class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        if (s.isEmpty()) return 0
        if (s.length == 1) return 1

        val charIndexMap = hashMapOf(s[0] to 0)
        var startIndex = 0
        var maxLength = 1
        IntRange(1, s.length - 1).forEach { index ->
            val char = s[index]
            if (char in charIndexMap && startIndex <= charIndexMap.getValue(char)) { // 중복이다
                startIndex = kotlin.math.max(startIndex, charIndexMap.getValue(char) + 1) // 이전 인덱스 다음 인덱스가 시작 인덱스가 된다.
            } else { // 중복이 아니면 최대값을 갱신한다.
                maxLength = kotlin.math.max(maxLength, index - startIndex + 1)
            }
            charIndexMap[char] = index
        }
        return maxLength
    }
}

fun main() {
    val solution = Solution()
    println(solution.lengthOfLongestSubstring("abcabcbb")) // 3
    println(solution.lengthOfLongestSubstring("bbbbb")) // 1
    println(solution.lengthOfLongestSubstring("pwwkew")) // 3
    println(solution.lengthOfLongestSubstring("tmmzuxt")) // 4
}