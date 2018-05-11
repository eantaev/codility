package com.antaev.codility;

class CountDivisibles {
    static int countDivisiblesBetween(int a, int b, int k) {
        return countDivisiblesLte(b, k) - countDivisiblesLte(a - 1, k);
    }

    /**
     * Count numbers v, s.t. 0 <= v <= a and d | v
     */
    static int countDivisiblesLte(int a, int d) {
        if (a < 0) {
            return 0;
        }
        return (a / d) + 1;
    }
}
