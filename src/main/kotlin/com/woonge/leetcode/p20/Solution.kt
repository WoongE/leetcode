package com.woonge.leetcode.p20

import java.util.*

class Solution {
    fun isValid(s: String): Boolean {
        val stack = Stack<Char>()
        s.forEach {
            if (it in Bracket.OPENS) {
                stack.push(it)
            } else {
                if (stack.isEmpty() || stack.pop() != Bracket.CLOSE_OPEN_MAP.getValue(it)) {
                    return false
                }
            }
        }
        return stack.isEmpty()
    }
}

enum class Bracket(
    private val open: Char,
    private val close: Char
) {
    S('(', ')'),
    M('{', '}'),
    L('[', ']');

    companion object {
        val OPENS = setOf(S.open, M.open, L.open)
        val CLOSE_OPEN_MAP = mapOf(
            S.close to S.open,
            M.close to M.open,
            L.close to L.open
        )
    }
}

fun main() {
    val solution = Solution()
    println(solution.isValid("()")) // true
    println(solution.isValid("()[]{}")) // true
    println(solution.isValid("(]")) // false
}