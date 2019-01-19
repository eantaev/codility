package com.antaev.com.antaev.leetcode;

public class IntegerDivision {
    public static int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        int sign = (dividend < 0) == (divisor < 0) ? 1 : -1;
        if (divisor < 0) {
            divisor = -divisor;
        }
        int result = 0;
        if (dividend == Integer.MIN_VALUE) {
            dividend += divisor;
            ++result;
        }
        if (dividend < 0) {
            dividend = -dividend;
        }
        int multiplier = 1;
        int d = divisor; // d = divisor * 2 ^ power = divisor * multiplier
        int limit = Integer.MAX_VALUE >> 1;
        while (d <= limit && (d << 1) <= dividend) {
            d <<= 1;
            multiplier <<= 1;
        }
        while (multiplier != 0) {
            while (d <= dividend) {
                dividend -= d;
                result += multiplier;
            }
            multiplier >>= 1;
            d >>= 1;
        }
        return result * sign;
    }
}
