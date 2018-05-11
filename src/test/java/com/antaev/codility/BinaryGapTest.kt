package com.antaev.codility

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class BinaryGapTest {

    @Test
    fun findMaxBinaryGapKotlin() {
        assertEquals(0, findMaxBinaryGap(0))
        assertEquals(0, findMaxBinaryGap(1))
        assertEquals(0, findMaxBinaryGap(15))
        assertEquals(0, findMaxBinaryGap(4))
        assertEquals(1, findMaxBinaryGap(10))
        assertEquals(2, findMaxBinaryGap(9))
        assertEquals(4, findMaxBinaryGap(529))
    }

    @Test
    fun findMaxBinaryGapJava() {
        assertEquals(0, BinaryGap.findMaxBinaryGap(0))
        assertEquals(0, BinaryGap.findMaxBinaryGap(1))
        assertEquals(0, BinaryGap.findMaxBinaryGap(15))
        assertEquals(0, BinaryGap.findMaxBinaryGap(4))
        assertEquals(1, BinaryGap.findMaxBinaryGap(10))
        assertEquals(2, BinaryGap.findMaxBinaryGap(9))
        assertEquals(4, BinaryGap.findMaxBinaryGap(529))
    }
}