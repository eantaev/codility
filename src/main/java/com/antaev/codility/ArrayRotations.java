package com.antaev.codility;

public final class ArrayRotations {
    private ArrayRotations() {
    }

    public static int[] rotate(int[] a, int k) {
        if (a == null) {
            throw new NullPointerException("a is null");
        }
        if (a.length == 0) {
            return a;
        }
        k %= a.length;
        if (k == 0) {
            return a;
        }
        // 0 < k < a.length
        reverse(a, 0, a.length - k);
        reverse(a, a.length - k, a.length);
        reverse(a, 0, a.length);
        return a;
    }

    static int[] reverse(int[] a, int startInclusive, int endExclusive) {
        int s = startInclusive;
        int e = endExclusive - 1;
        while (s < e) {
            int b = a[s];
            a[s] = a[e];
            a[e] = b;
            ++s;
            --e;
        }
        return a;
    }
}
