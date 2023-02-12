package com.woonge.leetcode.p21

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        if (list1 == null) return list2
        if (list2 == null) return list1

        var node1 = list1
        var node2 = list2

        val head: ListNode
        if (node1.`val` < node2.`val`) {
            head = node1
            node1 = node1.next
        } else {
            head = node2
            node2 = node2.next
        }

        var tail: ListNode = head
        while (node1 != null && node2 != null) {
            if (node1.`val` < node2.`val`) {
                tail.next = node1
                node1 = node1.next
            } else {
                tail.next = node2
                node2 = node2.next
            }
            tail = tail.next ?: throw IllegalStateException("불가능한 케이스")
        }
        tail.next = node1 ?: node2
        return head
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}