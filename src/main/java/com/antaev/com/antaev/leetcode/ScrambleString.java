package com.antaev.com.antaev.leetcode;

import java.util.Arrays;

public class ScrambleString {
    public static boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        return new Scramble(s1, s2).isScramble();
    }

    static class Scramble {
        final char[] q;
        final char[] r;
        final int[] charSet;

        Scramble(String s1, String s2) {
            this.q = s1.toCharArray();
            this.r = s2.toCharArray();
            this.charSet = new int[26];
        }

        boolean isScramble() {
            return isScramble(0, 0, q.length);
        }

        private boolean isScramble(int qStart, int rStart, int length) {
            if (equal(qStart, rStart, length)) {
                return true;
            }
            if (!equalCharCount(qStart, rStart, length)) {
                return false;
            }
            for (int len = 1; len != length; ++len) {
                if (isScramble(qStart, rStart, len)
                        && isScramble(qStart + len, rStart + len, length - len)) {
                    return true;
                }
                if (isScramble(qStart, rStart + length - len, len)
                        && isScramble(qStart + len, rStart, length - len)) {
                    return true;
                }
            }
            return false;
        }

        boolean equalCharCount(int qStart, int rStart, int length) {
            Arrays.fill(charSet, 0);
            for (int pos = 0; pos != length; ++pos) {
                ++charSet[q[qStart + pos] - 'a'];
                --charSet[r[rStart + pos] - 'a'];
            }
            for (int i = 0; i != charSet.length; ++i) {
                if (charSet[i] != 0) {
                    return false;
                }
            }
            return true;
        }

        boolean equal(int qStart, int rStart, int length) {
            for (int i = 0; i != length; ++i) {
                if (q[qStart] != r[rStart]) {
                    return false;
                }
                ++qStart;
                ++rStart;
            }
            return true;
        }
    }
}
