package com.antaev.codility;

import java.util.BitSet;

/**
 * https://app.codility.com/programmers/lessons/4-counting_elements/frog_river_one/
 */
class FrogRiverOne {
    static int findEarliest(int x, int[] a) {
        if (x <= 0) {
            return 0;
        }
        BitSet pos = new BitSet(x); // pos[p] -> position at p + 1
        int covered = 0;
        for (int t = 0; t < a.length; t++) {
            int p = a[t] - 1;
            if (!pos.get(p)) {
                pos.set(p);
                ++covered;
                if (covered == x) {
                    return t;
                }
            }
        }
        return -1;
    }
}
