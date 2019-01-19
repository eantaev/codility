package com.antaev.com.antaev.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaximalRectangleTest {
    @Test
    public void test() {
        assertEquals(1, MaximalRectangle.maximalRectangle(new char[][]{{'1'}}));
    }

    @Test
    public void test2() {
        assertEquals(6, MaximalRectangle.maximalRectangle(new char[][]{
                {'1', '0', '1', '1', '1'},
                {'0', '1', '0', '1', '0'},
                {'1', '1', '0', '1', '1'},
                {'1', '1', '0', '1', '1'},
                {'0', '1', '1', '1', '1'}}
        ));
    }
}