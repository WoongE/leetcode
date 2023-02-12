package com.woonge.leetcode.p9

/**
 * https://leetcode.com/problems/palindrome-number/
 */
class Solution {
    fun isPalindrome(x: Int): Boolean {
        if (x == 0) return true
        if (x < 0 || x % 10 == 0) {
            return false
        }
        val array = x.toString().toCharArray()
        val endIndex = array.size / 2
        for ((index, c) in array.withIndex()) {
            if (index >= endIndex) {
                break
            }

            if (c != array[array.size - index - 1]) {
                return false
            }
        }
        return true
    }
}

fun main() {
    println(Solution().isPalindrome(2332))
}