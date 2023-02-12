package com.woonge.leetcode.p26

class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        if (nums.isEmpty()) return 0
        var count = 1
        IntRange(1, nums.size - 1).forEach { i ->
            val cnt = nums[i]
            if (nums[count - 1] != cnt) { // 중복이 아니다. -> last, 카운트, 어레이 수정
                nums[count++] = cnt
            }
        }
        return count
    }
}