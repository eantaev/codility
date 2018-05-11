package com.antaev.codility;

import static java.lang.Math.max;

class MaxCounters {
    static int[] maxCounters(int n, int[] a) {
        int[] counters = new int[n]; // counters[i] holds a value of counter #i+1
        int currentMax = 0;
        int raisedTo = 0;
        // Inv 1. currentMax is max(counters)
        for (int v : a) {
            if (0 < v && v <= n) {
                counters[v - 1] = max(counters[v - 1], raisedTo);
                currentMax = max(currentMax, ++counters[v - 1]);
            } else if (v == n + 1) {
                raisedTo = currentMax;
            }
        }
        for (int i = 0; i < n; i++) {
            counters[i] = max(counters[i], raisedTo);
        }
        return counters;
    }
}
