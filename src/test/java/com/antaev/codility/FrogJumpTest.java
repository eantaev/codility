package com.antaev.codility;

import org.junit.Test;

import static com.antaev.codility.FrogJump.countJumps;
import static org.junit.Assert.assertEquals;

class FrogJumpTest {
    @Test
    void test() {
        assertEquals(0, countJumps(0, 0, 1));
        assertEquals(1, countJumps(0, 1, 3));
        assertEquals(1, countJumps(0, 2, 3));
        assertEquals(1, countJumps(0, 3, 3));
        assertEquals(2, countJumps(0, 4, 3));
        assertEquals(3, countJumps(10, 85, 30));
    }
}