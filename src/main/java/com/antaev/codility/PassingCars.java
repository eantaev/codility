package com.antaev.codility;

/**
 * https://app.codility.com/c/run/trainingWEPPFR-PP8
 */
class PassingCars {
    static int countPassingCars(int[] cars) {
        int zeroCount = 0;
        int crossCount = 0;
        for (int v : cars) {
            if (v == 0) {
                ++zeroCount;
            } else if (v == 1) {
                crossCount += zeroCount;
                if (crossCount > 1_000_000_000) {
                    return -1;
                }
            }
        }
        return crossCount;
    }
}
