package com.woonge.leetcode.p8

class Solution {
    fun myAtoi(s: String): Int {
        var parseStarted = false
        var isPositive = true
        var output = 0
        loop@ for (c in s) {
            when (c) {
                in '0'..'9' -> {
                    if ((!isPositive && output > 0) || (isPositive && output < 0)) {
                        output = -output
                    }
                    val right = if (isPositive) c - '0' else -(c - '0')
                    when {
                        isPositive && isPreOverMax(output, right) -> {
                            return Int.MAX_VALUE
                        }
                        !isPositive && isPreUnderMin(output, right) -> {
                            return Int.MIN_VALUE
                        }
                        else -> {
                            output = output * 10 + right
                            parseStarted = true
                        }
                    }
                }
                '-' -> if (!parseStarted) {
                    isPositive = false
                    parseStarted = true
                } else break@loop
                '+' -> if (!parseStarted) {
                    isPositive = true
                    parseStarted = true
                } else break@loop
                ' ' -> if (parseStarted) break@loop
                else -> break@loop
            }
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
    println(solution.myAtoi("42") == 42)
    println(solution.myAtoi("   -42") == -42)
    println(solution.myAtoi("4193 with words") == 4193)
    println(solution.myAtoi("9999999999") == Int.MAX_VALUE)
    println(solution.myAtoi("-9999999999") == Int.MIN_VALUE)
    println(solution.myAtoi("words and 987") == 0)
    println(solution.myAtoi("-21474836482") == Int.MIN_VALUE) // -2147483648
}