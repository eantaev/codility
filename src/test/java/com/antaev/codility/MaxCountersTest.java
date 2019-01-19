package com.antaev.codility;

import org.junit.Test;

import static com.antaev.codility.MaxCounters.maxCounters;
import static org.junit.Assert.assertArrayEquals;

class MaxCountersTest {
    @Test
    void test() {
        assertArrayEquals(new int[]{3, 2, 2, 4, 2}, maxCounters(5, new int[]{3, 4, 4, 6, 1, 4, 4}));
        assertArrayEquals(new int[]{1, 0}, maxCounters(2, new int[]{1}));
        assertArrayEquals(new int[]{2, 0}, maxCounters(2, new int[]{1, 1}));
        assertArrayEquals(new int[]{2, 2}, maxCounters(2, new int[]{1, 1, 3}));
        assertArrayEquals(new int[]{2, 2}, maxCounters(2, new int[]{1, 1, 2, 3}));
        assertArrayEquals(new int[]{2, 2}, maxCounters(2, new int[]{1, 1, 2, 2, 3}));
    }
}