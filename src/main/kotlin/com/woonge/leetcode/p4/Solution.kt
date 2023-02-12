package com.woonge.leetcode.p4

/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 */
class Solution {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val totalCount = nums1.size + nums2.size
        val isEven = totalCount % 2 == 0
        val targetIndex = totalCount / 2 // 3개면 (1) 4개면 (1, 2) 여야 하므로,

        var index1 = 0
        var index2 = 0
        var preValue: Int? = null
        var cntValue: Int? = null
        var cntIndex = 0

        while (index1 < nums1.size || index2 < nums2.size) {
            if (index1 < nums1.size && index2 < nums2.size) {
                if (nums1[index1] < nums2[index2]) {
                    preValue = cntValue
                    cntValue = nums1[index1++]
                } else {
                    preValue = cntValue
                    cntValue = nums2[index2++]
                }
            } else if (index1 < nums1.size) {
                preValue = cntValue
                cntValue = nums1[index1++]
            } else { // index2 < nums2.size
                preValue = cntValue
                cntValue = nums2[index2++]
            }

            if (cntIndex == targetIndex) {
                return if (isEven) {
                    ((preValue ?: 0) + (cntValue ?: 0)).toDouble() / 2
                } else {
                    cntValue.toDouble()
                }
            } else {
                cntIndex++
            }
        }
        throw IllegalStateException("불가능한 케이스")
    }
}

fun main() {
    val solution = Solution()
    println(solution.findMedianSortedArrays(intArrayOf(1, 3), intArrayOf(2))) // 2
    println(solution.findMedianSortedArrays(intArrayOf(1, 2), intArrayOf(3, 4))) // 2.5
}