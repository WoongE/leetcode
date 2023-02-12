package com.woonge.leetcode.p7

/**
 * https://leetcode.com/problems/reverse-integer/
 */
class Solution {
    fun reverse(x: Int): Int {
        val checker = if (x > 0) ::isPreOverMax else ::isPreUnderMin
        var input = x
        var output = 0
        while (input != 0) {
            if (checker(output, input % 10)) {
                return 0
            }
            output = output * 10 + input % 10
            input /= 10
        }
        return output
    }


    companion object {
        private const val PRE_MAX_LEFT = Int.MAX_VALUE / 10
        private const val PRE_MAX_RIGHT = Int.MAX_VALUE % 10
        private const val PRE_MIN_LEFT = Int.MIN_VALUE / 10
        private const val PRE_MIN_RIGHT = Int.MIN_VALUE % 10

        fun isPreOverMax(left: Int, right: Int): Boolean {
            return (left > PRE_MAX_LEFT) || (left == PRE_MAX_LEFT && right > PRE_MAX_RIGHT)
        }

        fun isPreUnderMin(left: Int, right: Int): Boolean {
            return (left < PRE_MIN_LEFT) || (left == PRE_MIN_LEFT && right < PRE_MIN_RIGHT)
        }
    }
}

fun main() {
    val solution = Solution()
    println(solution.reverse(123)) // 321
    println(solution.reverse(-123)) // -321
    println(solution.reverse(120)) // 21
    println(solution.reverse(19_9999_9999)) // 21
    println(solution.reverse(-19_9999_9999)) // 21
}