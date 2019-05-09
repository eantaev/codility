package com.antaev.leetcode;

import java.util.Arrays;

public class MaximalRectangle {
    public static int maximalRectangle(char[][] m) {
        int rows = m.length;
        if (rows == 0) {
            return 0;
        }
        int cols = m[0].length;
        if (cols == 0) {
            return 0;
        }
        int maxArea = 0;
        int[] height = new int[cols];
        int[] left = new int[cols];
        int[] right = new int[cols];
        Arrays.fill(right, cols - 1);
        for (int r = 0; r != rows; ++r) {
            int last1 = 0;
            for (int c = 0; c != cols; ++c) {
                if (m[r][c] == '1') {
                    left[c] = Math.max(left[c], last1);
                } else {
                    left[c] = 0;
                    last1 = c + 1;
                }
            }
            last1 = cols - 1;
            for (int c = cols - 1; c != -1; --c) {
                if (m[r][c] == '1') {
                    right[c] = Math.min(right[c], last1);
                } else {
                    right[c] = cols - 1;
                    last1 = c - 1;
                }
            }
            for (int c = 0; c != cols; ++c) {
                if (m[r][c] == '1') {
                    height[c] += 1;
                    maxArea = Math.max(maxArea, height[c] * (right[c] - left[c] + 1));
                } else {
                    height[c] = 0;
                }
            }
        }
        return maxArea;
    }
}
