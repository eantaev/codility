package com.antaev.com.antaev.leetcode;

public class RabinKarp {
    public static int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }
        int base = 256;
        int modulo = 101;
        int needleHash = 0;
        int haystackHash = 0;
        int msdPower = 1;
        for (int i = 0; i < needle.length(); ++i) {
            needleHash = ((needleHash * base) % modulo + needle.charAt(i)) % modulo;
            haystackHash = ((haystackHash * base) % modulo + haystack.charAt(i)) % modulo;
            if (i != 0)
                msdPower = (msdPower * base) % modulo;
        }
        if (needleHash == haystackHash && haystack.regionMatches(0, needle, 0, needle.length())) {
            return 0;
        }
        int start = 0;
        for (int i = needle.length(); i < haystack.length(); ++i) {
            haystackHash += modulo;
            haystackHash -= (msdPower * haystack.charAt(start)) % modulo;
            haystackHash *= base;
            haystackHash += haystack.charAt(i);
            haystackHash %= modulo;
            ++start;
            if (needleHash == haystackHash && haystack.regionMatches(start, needle, 0, needle.length())) {
                return start;
            }
        }
        return -1;
    }
}
