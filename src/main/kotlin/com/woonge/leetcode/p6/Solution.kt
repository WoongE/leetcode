package com.woonge.leetcode.p6

/**
 * https://leetcode.com/problems/zigzag-conversion/
 *
 * 0   4   8
 * 1 3 5 7 9
 * 2   6
 *
 *
 * 0     6       12       18
 * 1   5 7    11 13    17 19
 * 2 4   8 10    14 16    20
 * 3     9       15       21
 *
 * 0
 * 1     7
 * 2   6
 * 3 5
 * 4
 *
 */
class Solution {
    fun convert(s: String, numRows: Int): String {
        if (numRows == 1) {
            return s
        }

        val listOfList: ArrayList<ArrayList<Char>> = ArrayList()
        for (i in IntRange(0, numRows - 1)) {
            listOfList.add(arrayListOf())
        }

        val indexIterator = CircularIndexIterator(numRows)
        s.forEach { listOfList[indexIterator.next()].add(it) }
        return listOfList.joinToString("") { it.joinToString("") }
    }
}

class CircularIndexIterator(val size: Int) {
    private var index = 0
    private var step = 1 // true: 양의 방향, false: 음의 방향

    fun next(): Int {
        val result = index
        if ((index + step >= size) || (index + step < 0)) {
            step = -step
        }
        index += step
        return result
    }
}

fun main() {
    val solution = Solution()
    println(solution.convert("PAYPALISHIRING", 3) == "PAHNAPLSIIGYIR")
    println(solution.convert("PAYPALISHIRING", 4) == "PINALSIGYAHRPI")
    println(solution.convert("A", 1) == "A")
    println(solution.convert("AB", 1) == "AB")
}