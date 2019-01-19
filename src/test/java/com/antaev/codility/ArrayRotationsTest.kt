package com.antaev.codility

import com.antaev.codility.ArrayRotations.reverse
import com.antaev.codility.ArrayRotations.rotate
import org.junit.Assert.assertArrayEquals
import org.junit.Test

class ArrayRotationsTest {

    @Test
    fun rotate() {
        assertArrayEquals(intArrayOf(1, 2, 3), rotate(intArrayOf(1, 2, 3), 0))
        assertArrayEquals(intArrayOf(1, 2, 3), rotate(intArrayOf(1, 2, 3), 3))
        assertArrayEquals(intArrayOf(3, 1, 2), rotate(intArrayOf(1, 2, 3), 1))
        assertArrayEquals(intArrayOf(2, 3, 1), rotate(intArrayOf(1, 2, 3), 2))

        assertArrayEquals(intArrayOf(9, 7, 6, 3, 8), rotate(intArrayOf(3, 8, 9, 7, 6), 3))
    }

    @Test
    fun reverseTest() {
        assertArrayEquals(intArrayOf(1, 2, 3), reverse(intArrayOf(1, 2, 3), 0, 0))
        assertArrayEquals(intArrayOf(2, 1, 3), reverse(intArrayOf(1, 2, 3), 0, 2))
        assertArrayEquals(intArrayOf(3, 2, 1), reverse(intArrayOf(1, 2, 3), 0, 3))
    }
}