package com.antaev.com.antaev.leetcode

import com.antaev.com.antaev.leetcode.IntegerToRoman.parseRoman
import com.antaev.com.antaev.leetcode.IntegerToRoman.roman
import org.junit.Assert.*
import org.junit.Test

class IntegerToRomanTest {
    @Test
    fun encode() {
        assertEquals("III", roman(3))
        assertEquals("IV", roman(4))
        assertEquals("V", roman(5))
        assertEquals("IX", roman(9))
        assertEquals("LVIII", roman(58))
        assertEquals("MCMXCIV", roman(1994))
    }

    @Test
    fun decode() {
        assertEquals(3, parseRoman("III"))
        assertEquals(4, parseRoman("IV"))
        assertEquals(5, parseRoman("V"))
        assertEquals(9, parseRoman("IX"))
        assertEquals(58, parseRoman("LVIII"))
        assertEquals(1994, parseRoman("MCMXCIV"))
    }
}