package com.antaev.codility;

import org.junit.Test;

import static com.antaev.codility.PermMissingElem.findMissing;
import static org.junit.Assert.assertEquals;

class PermMissingElemTest {
    @Test
    void test() {
        assertEquals(1, findMissing(new int[]{2, 3, 4, 5}));
        assertEquals(2, findMissing(new int[]{1, 3, 4, 5}));
        assertEquals(4, findMissing(new int[]{2, 3, 1, 5}));
    }
}