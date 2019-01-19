package com.antaev.leetcode.median_of_two_sorted_arrays

import kotlin.math.min

object MedianOfTwoSortedArrays {

    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val size = nums1.size + nums2.size
        val isMedianSplit = size % 2 == 0
        val firstMedianIndex = if (isMedianSplit) size / 2 - 1 else size / 2

        var v1 = SubArray(nums1)
        var v2 = SubArray(nums2)

        while (true) {
            if (v1.size() < v2.size()) {
                val t = v1; v1 = v2; v2 = t // swap v1 and v2
            }
            // v1.size() >= v2.size()
            val midIndex1 = v1.midIndex()
            val mid1 = v1.values[midIndex1]
            val midIndex2 = v2.countLte(mid1)
            val globalIndex = midIndex1 + midIndex2
            when {
                globalIndex < firstMedianIndex -> {
                    v1.start = midIndex1 + 1
                    v2.start = midIndex2
                }
                firstMedianIndex < globalIndex -> {
                    v1.end = midIndex1
                    v2.end = midIndex2
                }
                else -> {
                    if (!isMedianSplit)
                        return mid1.toDouble()
                    val mid2 = min(
                        v1.getOrMaxInt(midIndex1 + 1),
                        v2.getOrMaxInt(midIndex2)
                    )
                    return (mid1.toDouble() + mid2.toDouble()) / 2
                }
            }
        }
    }
}

class SubArray(
    val values: IntArray,
    var start: Int = 0, // inclusive
    var end: Int = values.size // exclusive
) {
    fun size(): Int = end - start

    fun midIndex(): Int = start + (end - start) / 2

    fun getOrMaxInt(index: Int): Int = if (index < values.size) values[index] else Int.MAX_VALUE

    /**
     * returns number of elements that are lte [p] in [values].
     * [start] and [end] are used as an initial interval.
     */
    fun countLte(p: Int): Int {
        if (start == end)
            return start
        var s = start
        var e = end - 1
        while (true) {
            val m = s + (e - s) / 2
            val v = values[m]
            if (v <= p) {
                s = m + 1
                if (s > e)
                    break
            } else {
                e = m
                if (s == e)
                    break
            }
        }
        return s
    }
}
