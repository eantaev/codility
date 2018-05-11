package com.antaev.codility;

import java.util.BitSet;

class FindSmallestMissingElement {
    static int findMissing(int[] a) {
        BitSet bs = new BitSet(a.length); // bs[i] <=> i+1 is in a
        for (int v : a) {
            if (0 < v && v <= a.length) {
                bs.set(v - 1);
            }
        }
        for (int i = 0; i < a.length; ++i) {
            if (!bs.get(i)) {
                return i + 1;
            }
        }
        return a.length + 1;
    }
}
