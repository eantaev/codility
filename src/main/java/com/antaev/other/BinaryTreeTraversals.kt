package com.antaev.other

import java.util.*

object BinaryTreeTraversals {
    data class Node<T>(val value: T, val left: Node<T>? = null, val right: Node<T>? = null)

    fun <T> preOrder(root: Node<T>?): List<T> {
        val traversal = ArrayList<T>()
        var cur = root;
        val s = ArrayDeque<Node<T>>()
        while (!s.isEmpty() || cur != null) {
            if (cur == null) {
                cur = s.removeLast().right
            } else {
                traversal += cur.value
                s.addLast(cur)
                cur = cur.left
            }
        }
        return traversal
    }

    fun <T> inOrder(root: Node<T>?): List<T> {
        val traversal = ArrayList<T>()
        var cur = root
        val s = ArrayDeque<Node<T>>()
        while (!s.isEmpty() || cur != null) {
            if (cur == null) {
                cur = s.removeLast()
                traversal += cur.value
                cur = cur.right
            } else {
                s.add(cur)
                cur = cur.left
            }
        }
        return traversal
    }

    fun <T> postOrder(root: Node<T>?): List<T> {
        val traversal = ArrayList<T>()
        val s = ArrayDeque<Node<T>>()
        val re = HashSet<Node<T>>() // right edge explored
        var cur = root
        while (!s.isEmpty() || cur != null) {
            if (cur == null) {
                cur = s.removeLast()
                if (cur in re) {
                    traversal += cur.value
                    cur = null
                } else {
                    re += cur
                    s.addLast(cur)
                    cur = cur.right
                }
            } else {
                s.addLast(cur)
                cur = cur.left
            }
        }
        return traversal
    }
}