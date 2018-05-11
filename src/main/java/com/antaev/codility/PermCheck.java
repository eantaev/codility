package com.antaev.codility;

import java.util.BitSet;

class PermCheck {
    /**
     * Return true if 'a' contains a permutation of [1..a.length]
     */
    static boolean isPermutation(int a[]) {
        BitSet bs = new BitSet(a.length);
        for (int v : a) {
            if (v < 1 || v > a.length || bs.get(v - 1))
                return false;
            bs.set(v - 1);
        }
        return true;
    }
}
