package com.woonge.leetcode.p2

/**
 * https://leetcode.com/problems/add-two-numbers/
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        if (l1 == null) return l2
        if (l2 == null) return l1

        var (head, carry) = add(l1, l2, 0)

        var tail: ListNode = head
        var node1 = l1.next
        var node2 = l2.next
        while (node1 != null || node2 != null) {
            val (newNode, newCarry) = add(node1, node2, carry)
            tail.next = newNode
            tail = tail.next ?: throw IllegalStateException("불가능")
            carry = newCarry
            node1 = node1?.next
            node2 = node2?.next
        }
        if (carry > 0) {
            tail.next = ListNode(carry)
        }
        return head
    }


    private fun add(l1: ListNode?, l2: ListNode?, carry: Int): Pair<ListNode, Int> {
        val sum = (l1?.`val` ?: 0) + (l2?.`val` ?: 0) + carry
        return ListNode(sum % 10) to sum / 10
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}