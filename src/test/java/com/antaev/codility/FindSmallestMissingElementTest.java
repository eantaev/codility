package com.antaev.codility;

import org.junit.jupiter.api.Test;

import static com.antaev.codility.FindSmallestMissingElement.findMissing;
import static org.junit.jupiter.api.Assertions.*;

class FindSmallestMissingElementTest {
    @Test
    void test() {
        assertEquals(1, findMissing(new int[] {}));
        assertEquals(1, findMissing(new int[] {2, 3, 5}));
        assertEquals(2, findMissing(new int[] {1}));
        assertEquals(3, findMissing(new int[] {4, 2, 1}));
        assertEquals(1, findMissing(new int[] {-1}));
        assertEquals(2, findMissing(new int[] {-1, 1}));
    }
}