package com.antaev.com.antaev.leetcode;

import java.util.Arrays;

public class WildCardMatching {
    public static boolean isMatch(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }

        Pattern pattern = new Pattern(p);
        return matches(s, 0, pattern, 0);
    }

    public static boolean dpMatches(String s, String pattern) {
        if (pattern.isEmpty()) {
            return s.isEmpty();
        }
        Pattern p = new Pattern(pattern);
        boolean[][] m = new boolean[s.length() + 1][p.length + 1];
        m[s.length()][p.length] = true; // "" matches ""
        int i = p.length - 1;
        while (i >= 0 && p.p[i] == '*') {
            m[s.length()][i] = true;
            --i;
        }
        for (int si = s.length() - 1; si >= 0; --si) {
            for (int pi = p.length - 1; pi >= 0; --pi) {
                char sc = s.charAt(si);
                char pc = p.p[pi];
                if (sc == pc || pc == '?') {
                    m[si][pi] = m[si + 1][pi + 1];
                } else if (pc == '*') {
                    m[si][pi] = m[si][pi + 1] || m[si + 1][pi];
                }
            }
        }
        return m[0][0];
    }

    private static class Pattern {
        final String pattern;
        final char[] p;
        final int[] minLength;
        final int length;

        Pattern(String p) {
            // assert !p.isEmpty()
            char[] b = new char[p.length()];
            int len = 0;
            b[len++] = p.charAt(0);
            for (int i = 1; i < p.length(); ++i) {
                char pc = p.charAt(i);
                if (b[len - 1] != '*' || pc != '*') {
                    b[len++] = pc;
                }
            }
            int[] ml = new int[len];
            int c = 0;
            for (int i = len - 1; i >= 0; --i) {
                if (b[i] != '*') {
                    ++c;
                }
                ml[i] = c;
            }
            this.p = Arrays.copyOf(b, len);
            this.pattern = new String(b, 0, len);
            this.minLength = ml;
            this.length = len;
        }
    }

    private static boolean matches(String s, int si, Pattern p, int pi) {
        char sc;
        char pc;
        do {
            if (si == s.length() && pi == p.length) {
                return true;
            }
            if (pi == p.length) {
                return false;
            }
            if (s.length() - si < p.minLength[pi]) {
                return false;
            }
            if (si == s.length()) {
                return true;
            }
            // s[si:] and p[pi:] are both not empty
            sc = s.charAt(si);
            pc = p.pattern.charAt(pi);
            if (sc == pc || pc == '?') {
                ++si;
                ++pi;
            }
        } while (sc == pc || pc == '?');
        if (pc == '*') {
            while (s.length() - si >= p.minLength[pi]) {
                if (matches(s, si, p, pi + 1)) {
                    return true;
                }
                ++si;
            }
        }
//        if (pc == '*') {
//            return matches(s, si, p, pi + 1) || matches(s, si + 1, p, pi);
//        }
        return false;
    }
}
