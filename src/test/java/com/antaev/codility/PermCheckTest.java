package com.antaev.codility;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PermCheckTest {
    @Test
    void test() {
        assertTrue(PermCheck.isPermutation(new int[]{1}));
        assertTrue(PermCheck.isPermutation(new int[]{1, 2, 3, 4}));
        assertTrue(PermCheck.isPermutation(new int[]{4, 3, 1, 2}));

        assertFalse(PermCheck.isPermutation(new int[]{0}));
        assertFalse(PermCheck.isPermutation(new int[]{2}));
        assertFalse(PermCheck.isPermutation(new int[]{4, 3, 2, 2}));
    }
}