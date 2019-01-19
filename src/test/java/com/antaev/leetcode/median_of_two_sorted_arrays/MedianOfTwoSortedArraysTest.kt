package com.antaev.leetcode.median_of_two_sorted_arrays

import com.antaev.leetcode.median_of_two_sorted_arrays.MedianOfTwoSortedArrays.findMedianSortedArrays
import org.junit.Test
import kotlin.test.assertEquals

class MedianOfTwoSortedArraysTest {
    @Test
    fun `SubArray countLte`() {
        assertEquals(0, SubArray(intArrayOf()).countLte(1))
        assertEquals(0, SubArray(intArrayOf(2)).countLte(1))
        assertEquals(0, SubArray(intArrayOf(2, 3)).countLte(1))
        assertEquals(1, SubArray(intArrayOf(2)).countLte(2))
        assertEquals(1, SubArray(intArrayOf(2, 3)).countLte(2))
        assertEquals(2, SubArray(intArrayOf(2, 2, 3)).countLte(2))
        assertEquals(2, SubArray(intArrayOf(1, 2)).countLte(2))
        assertEquals(3, SubArray(intArrayOf(1, 2, 2)).countLte(2))
        assertEquals(4, SubArray(intArrayOf(1, 2, 2, 2)).countLte(2))
    }

    @Test
    fun `SubArray countLte with boundaries`() {
        assertEquals(0, SubArray(intArrayOf(), 0, 0).countLte(1))
        assertEquals(0, SubArray(intArrayOf(2), 0, 0).countLte(1))
        assertEquals(1, SubArray(intArrayOf(2, 3), 0, 1).countLte(2))
        assertEquals(2, SubArray(intArrayOf(2, 2, 3), 2, 2).countLte(2))
        assertEquals(1, SubArray(intArrayOf(2, 2, 3), 0, 1).countLte(2))
        assertEquals(1, SubArray(intArrayOf(1, 2), 0, 1).countLte(2))
        assertEquals(3, SubArray(intArrayOf(1, 2, 2), 0, 3).countLte(2))
        assertEquals(2, SubArray(intArrayOf(1, 2, 2, 2), 2, 2).countLte(2))
    }

    @Test
    fun findMedian() {
        assertEquals(1.0, findMedianSortedArrays(arr(1), arr()))
        assertEquals(1.0, findMedianSortedArrays(arr(), arr(1)))
        assertEquals(1.0, findMedianSortedArrays(arr(1), arr(1)))
        assertEquals(1.0, findMedianSortedArrays(arr(1, 2), arr(1)))
        assertEquals(1.5, findMedianSortedArrays(arr(1, 2), arr(1, 2)))
        assertEquals(2.0, findMedianSortedArrays(arr(1, 2, 3), arr(1, 2)))
        assertEquals(2.5, findMedianSortedArrays(arr(1, 2, 3), arr(4)))
        assertEquals(2.0, findMedianSortedArrays(arr(1, 2, 3), arr(0, 4)))
        assertEquals(1.5, findMedianSortedArrays(arr(1, 2, 3), arr(0, 1, 4)))
    }

    @Test
    fun t() {
        var x = 10
        x /= 10
        val s = "hello world"
        for (i in 1 until s.length - 1) {
            print(s[i])
        }
    }
    companion object {
        fun arr(vararg elements: Int): IntArray = intArrayOf(*elements)
    }
}
