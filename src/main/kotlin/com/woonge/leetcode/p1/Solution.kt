package com.woonge.leetcode.p1

class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val valueIndexMap = HashMap<Int, Int>()
        for ((index, num) in nums.withIndex()) {
            if (num in valueIndexMap) {
                return intArrayOf(valueIndexMap.getValue(num), index)
            }
            valueIndexMap[target - num] = index
        }
        throw IllegalArgumentException("답이 있다면서요?")
    }
}