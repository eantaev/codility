package com.antaev.other

import com.antaev.other.BinaryTreeTraversals.Node
import com.antaev.other.BinaryTreeTraversals.inOrder
import com.antaev.other.BinaryTreeTraversals.postOrder
import com.antaev.other.BinaryTreeTraversals.preOrder
import org.junit.Assert.*
import org.junit.Test

class BinaryTreeTraversalsTest {
    @Test
    fun
        `pre-order traversal`() {
        assertEquals(emptyList<Int>(), preOrder<Int>(null))
        assertEquals(listOf(1), preOrder(Node(1)))
        assertEquals(listOf(1, 2, 3), preOrder(Node(1, left = Node(2), right = Node(3))))
        assertEquals(
            listOf(1, 2, 3, 4),
            preOrder(
                Node(
                    1,
                    left = Node(2, right = Node(3)),
                    right = Node(4)
                )
            )
        )
        assertEquals(
            listOf(1, 2, 3, 4, 5),
            preOrder(
                Node(
                    1,
                    left = Node(
                        2,
                        right = Node(3)
                    ),
                    right = Node(
                        4,
                        right = Node(5)
                    )
                )
            )
        )
    }

    @Test
    fun `in-order traversal`() {
        assertEquals(emptyList<Int>(), inOrder<Int>(null))
        assertEquals(listOf(1), inOrder(Node(1)))
        assertEquals(listOf(2, 1, 3), inOrder(Node(1, left = Node(2), right = Node(3))))
        assertEquals(
            listOf(2, 3, 1, 4),
            inOrder(
                Node(
                    1,
                    left = Node(2, right = Node(3)),
                    right = Node(4)
                )
            )
        )
        assertEquals(
            listOf(2, 3, 1, 4, 5),
            inOrder(
                Node(
                    1,
                    left = Node(
                        2,
                        right = Node(3)
                    ),
                    right = Node(
                        4,
                        right = Node(5)
                    )
                )
            )
        )
    }

    @Test
    fun `post-order traversal`() {
        assertEquals(emptyList<Int>(), postOrder<Int>(null))
        assertEquals(listOf(1), postOrder(Node(1)))
        assertEquals(listOf(2, 3, 1), postOrder(Node(1, left = Node(2), right = Node(3))))
        assertEquals(
            listOf(3, 2, 4, 1),
            postOrder(
                Node(
                    1,
                    left = Node(2, right = Node(3)),
                    right = Node(4)
                )
            )
        )
        assertEquals(
            listOf(3, 2, 5, 4, 1),
            postOrder(
                Node(
                    1,
                    left = Node(
                        2,
                        right = Node(3)
                    ),
                    right = Node(
                        4,
                        right = Node(5)
                    )
                )
            )
        )
    }
}