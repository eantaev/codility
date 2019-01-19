package com.antaev.com.antaev.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class RabinKarpTest {
    @Test
    public void test() {
        assertEquals(2, RabinKarp.strStr("hello", "ll"));
        assertEquals(0, RabinKarp.strStr("hello", "h"));
        assertEquals(4, RabinKarp.strStr("hello", "o"));
    }
}