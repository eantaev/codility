package com.antaev.com.antaev.leetcode

import org.junit.Assert.*
import org.junit.Test

class ReverseIntegerTest {
    @Test
    fun test() {
        val reversed = ReverseInteger.reverse(1534236469)
        println(reversed)
        /*
        9
        96
        964
        9646
        96463
        964632
        9646324
        96463243
        964632435
        1056389759
         */
    }

    @Test
    fun test2() {
        val v: Long = 1L + ('1' - '0')
        val digit = "1"[0].isDigit()
        println(digit)
    }
}