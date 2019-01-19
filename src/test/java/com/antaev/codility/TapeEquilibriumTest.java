package com.antaev.codility;


import org.junit.Test;

import static com.antaev.codility.TapeEquilibrium.findEquilibrium;
import static org.junit.Assert.assertEquals;

class TapeEquilibriumTest {
    @Test
    void test() {
        assertEquals(0, findEquilibrium(new int[]{0}));
        assertEquals(1, findEquilibrium(new int[]{1}));
        assertEquals(0, findEquilibrium(new int[]{1, 1}));
        assertEquals(1, findEquilibrium(new int[]{10, 9}));
        assertEquals(1, findEquilibrium(new int[]{9, 10}));
        assertEquals(1, findEquilibrium(new int[]{3, 1, 2, 4, 3}));
    }
}