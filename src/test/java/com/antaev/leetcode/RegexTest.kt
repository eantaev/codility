package com.antaev.leetcode

import com.antaev.leetcode.Regex
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class RegexTest {
    @Test
    fun test() {
        assertFalse(Regex.matches("aa", "a"))
        assertTrue(Regex.matches("aa", "a*"))
        assertTrue(Regex.matches("ab", "a.*"))
        assertTrue(Regex.matches("aab", "c*a*b*"))
        assertFalse(Regex.matches("mississippi", "mis*is*p*."))
        assertTrue(Regex.matches("a", "ab*"))
    }
}