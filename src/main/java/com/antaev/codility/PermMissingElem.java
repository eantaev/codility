package com.antaev.codility;

/**
 * https://app.codility.com/programmers/lessons/3-time_complexity/perm_missing_elem/
 */
final class PermMissingElem {
    static int findMissing(int a[]) {
        int minValue = 1;
        int maxValue = a.length + 1;

        int totalXor = 0;
        for (int v = minValue; v <= maxValue; ++v) {
            totalXor ^= v;
        }

        int aXor = 0;
        for (int v : a) {
            aXor ^= v;
        }

        return totalXor ^ aXor;
    }
}
