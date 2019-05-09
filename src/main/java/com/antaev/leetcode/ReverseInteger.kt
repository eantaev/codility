package com.antaev.leetcode

object ReverseInteger {
    fun reverse(x: Int): Int {
        if (x == Int.MIN_VALUE)
            return 0
        var v = x
        val sign = if (v < 0) {
            v = -v;
            -1
        } else 1
        // v >= 0
        var result = 0L
        while (v != 0) {
            val d = v % 10
            result = 10 * result + d
            if (result > Int.MAX_VALUE) {
                // overflow
                return 0
            }
            v /= 10
        }
        return result.toInt() * sign
    }
}