package com.antaev.leetcode;

import com.antaev.leetcode.ScrambleString;
import org.junit.Test;

import static com.antaev.leetcode.ScrambleString.isScramble;
import static org.junit.Assert.*;


public class ScrambleStringTest {
    @Test
    public void test0(){
        assertTrue(isScramble("", ""));
        assertTrue(isScramble("g", "g"));
        assertFalse(isScramble("a", "b"));
        assertFalse(isScramble("", "b"));
        assertFalse(isScramble("a", ""));
        assertFalse(isScramble("aa", "a"));
        assertFalse(isScramble("aa", "ab"));
    }

    @Test
    public void test1() {
        assertTrue(isScramble("ab", "ba"));
    }

    @Test
    public void test2() {
        assertTrue(isScramble("great", "rgeat"));
    }

    @Test
    public void test3() {
        assertFalse(isScramble("abcde", "caebd"));
    }

    @Test
    public void equalCharCount() {
        ScrambleString.Scramble scr = new ScrambleString.Scramble("ab", "ba");
        assertTrue(scr.equal(0, 1, 1));
        assertTrue(scr.equal(1, 0, 1));
        assertTrue(scr.equalCharCount(0, 0, 2));
    }
}