package com.antaev.codility;

import org.junit.jupiter.api.Test;

import static com.antaev.codility.FrogRiverOne.findEarliest;
import static org.junit.jupiter.api.Assertions.*;

class FrogRiverOneTest {
    @Test
    void test() {
        assertEquals(6, findEarliest(5, new int[]{1, 3, 1, 4, 2, 3, 5, 4}));
        assertEquals(0, findEarliest(1, new int[]{1}));
        assertEquals(-1, findEarliest(1, new int[]{}));
        assertEquals(-1, findEarliest(2, new int[]{1}));
        assertEquals(-1, findEarliest(5, new int[]{1, 3, 1, 4, 2, 3, 4, 4}));
    }

}