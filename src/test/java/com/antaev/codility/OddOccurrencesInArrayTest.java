package com.antaev.codility;

import org.junit.Test;

import static com.antaev.codility.OddOccurrencesInArray.findOddOccurrence;
import static org.junit.Assert.assertEquals;

class OddOccurrencesInArrayTest {
    @Test
    void test() {
        assertEquals(0, findOddOccurrence(new int[]{1, 2, 3, 1, 2, 3}));
        assertEquals(1, findOddOccurrence(new int[]{2, 3, 1, 2, 3}));
        assertEquals(0, findOddOccurrence(new int[]{1, 2, 3, 1, 2, 3, 0}));
    }
}