package com.antaev.codility;

import org.junit.jupiter.api.Test;

import static com.antaev.codility.PassingCars.countPassingCars;
import static org.junit.jupiter.api.Assertions.*;

class PassingCarsTest {
    @Test
    void test() {
        assertEquals(0, countPassingCars(new int[]{0, 0}));
        assertEquals(0, countPassingCars(new int[]{1, 1}));
        assertEquals(0, countPassingCars(new int[]{1, 0}));
        assertEquals(0, countPassingCars(new int[]{1, 1, 1, 0, 0, 0}));
        assertEquals(5, countPassingCars(new int[]{0, 1, 0, 1, 1}));
    }
}