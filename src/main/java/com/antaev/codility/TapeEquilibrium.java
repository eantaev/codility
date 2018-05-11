package com.antaev.codility;

final class TapeEquilibrium {
    static int findEquilibrium(int[] a) {
        int prefix = a[0];
        int suffix = sum(a, 1, a.length);
        int diff = Math.abs(prefix - suffix);
        int minDiff = diff;

        // Inv: minDiff contains min diff for 0 < pivot <= p
        for (int p = 1, end = a.length - 1; p < end; ++p) {
            int v = a[p];
            prefix += v;
            suffix -= v;
            diff = Math.abs(prefix - suffix);
            if (diff < minDiff) {
                minDiff = diff;
            }
        }
        // minDiff contains min diff for 0 < pivot < a.length - 2, i.e. for all possible pivot positions
        return minDiff;
    }

    private static int sum(int[] a, int startInclusive, int endExclusive) {
        int s = 0;
        for (int i = startInclusive; i < endExclusive; ++i) {
            s += a[i];
        }
        return s;
    }
}
