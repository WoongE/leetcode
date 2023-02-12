package com.woonge.leetcode.p13

/**
 * https://leetcode.com/problems/roman-to-integer/
 *
 */
class Solution {
    fun romanToInt(s: String): Int {
        val romanNumerals = s.map { RomanNumeral.valueOf("$it") }
        return romanNumerals
            .mapIndexed { i, romanNumeral -> romanNumeral.toArabicNumeral(if (i > 0) romanNumerals[i - 1] else null) }
            .sum()
    }
}

enum class RomanNumeral(private val arabicNumeral: Int) {
    I(1),
    V(5),
    X(10),
    L(50),
    C(100),
    D(500),
    M(1000);

    fun toArabicNumeral(before: RomanNumeral?): Int = when (this) {
        I -> arabicNumeral
        V -> when (before) {
            I -> arabicNumeral - 2 * before.arabicNumeral
            V -> throw IllegalArgumentException("V가 왜 연속으로 두 번 나와요?")
            else -> arabicNumeral
        }
        X -> when (before) {
            I -> arabicNumeral - 2 * before.arabicNumeral
            else -> arabicNumeral
        }
        L -> when (before) {
            I, V -> throw IllegalArgumentException("뭐야 순서가 이상해.")
            X -> arabicNumeral - 2 * before.arabicNumeral
            L -> throw IllegalArgumentException("L이 왜 연속으로 두 번 나와요?")
            else -> arabicNumeral
        }
        C -> when (before) {
            I, V, L -> throw IllegalArgumentException("뭐야 순서가 이상해.")
            X -> arabicNumeral - 2 * before.arabicNumeral
            else -> arabicNumeral
        }
        D -> when (before) {
            I, V, X, L -> throw IllegalArgumentException("뭐야 순서가 이상해.")
            C -> arabicNumeral - 2 * before.arabicNumeral
            D -> throw IllegalArgumentException("D가 왜 연속으로 두 번 나와요?")
            else -> arabicNumeral
        }
        M -> when (before) {
            I, V, X, L, D -> throw IllegalArgumentException("뭐야 순서가 이상해.")
            C -> arabicNumeral - 2 * before.arabicNumeral
            else -> arabicNumeral
        }
    }
}

fun main() {
    val solution = Solution()
    println(solution.romanToInt("III")) // 3
    println(solution.romanToInt("LVIII")) // 58
    println(solution.romanToInt("MCMXCIV")) // 1994
}


