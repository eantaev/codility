package com.antaev.codility;

import org.junit.Test;

import static com.antaev.codility.CountDivisibles.countDivisiblesBetween;
import static com.antaev.codility.CountDivisibles.countDivisiblesLte;
import static org.junit.Assert.assertEquals;

class CountDivisiblesTest {

    @Test
    void countDivisiblesBetweenTest() {
        assertEquals(0, countDivisiblesBetween(-1, -1, 2));
        assertEquals(1, countDivisiblesBetween(-1, 0, 2));
        assertEquals(1, countDivisiblesBetween(-1, 1, 2));
        assertEquals(2, countDivisiblesBetween(-1, 2, 2));
        assertEquals(2, countDivisiblesBetween(-1, 3, 2));
        assertEquals(3, countDivisiblesBetween(6, 11, 2));
    }

    @Test
    void countDivisiblesLteTest() {
        assertEquals(0, countDivisiblesLte(-1, 2));
        assertEquals(1, countDivisiblesLte(0, 2));
        assertEquals(1, countDivisiblesLte(1, 2));
        assertEquals(2, countDivisiblesLte(2, 2));
        assertEquals(2, countDivisiblesLte(3, 2));
    }
}