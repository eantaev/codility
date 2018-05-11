package com.antaev.codility;

public final class BinaryGap {
    public static int findMaxBinaryGap(int n) {
        if (n < 0)
            throw new IllegalArgumentException("Argument (" + n + " ) < 0");

        // get rid of trailing zeros
        while (n != 0 && (n & 1) == 0)
            n >>= 1;
        // n ends with '1' or n is 0

        int maxGap = 0;
        int currentGap = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                if (currentGap > maxGap)
                    maxGap = currentGap;
                currentGap = 0;
            } else
                ++currentGap;
            n >>= 1;
        }
        return maxGap;
    }
}
