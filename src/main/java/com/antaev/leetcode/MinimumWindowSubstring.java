package com.antaev.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int slen = s.length();
        int tlen = t.length();
        if (slen == 0 || tlen == 0) {
            return "";
        }
        Map<Character, Integer> letters = new HashMap<>(tlen * 4 / 3);
        for (int i = 0; i != tlen; ++i) {
            char ch = t.charAt(i);
            Integer count = letters.get(ch);
            if (count == null) {
                count = 0;
            }
            letters.put(ch, count + 1);
        }
        int nLettersCompleted = 0;
        Deque<Integer> positions = new ArrayDeque<Integer>();
        Map<Character, Integer> counters = new HashMap<>(tlen * 4 / 3);
        int minWindow = -1;
        int minWindowStart = 0;
        // Inv positions and counters represent the same content
        for (int i = 0; i != slen; ++i) {
            Character c = s.charAt(i);
            if (letters.containsKey(c)) {
                Integer count = counters.get(c);
                if (count == null) {
                    count = 0;
                }
                counters.put(c, count + 1);
                positions.addLast(i);
                if (count.equals(letters.get(c))) { // last added letter was redundant
                    while (true) {
                        if (positions.isEmpty()) {
                            break;
                        }
                        int headPos = positions.peekFirst();
                        char headChar = s.charAt(headPos);
                        int availableChars = counters.get(headChar);
                        if (availableChars <= letters.get(headChar)) {
                            break;
                        }
                        positions.removeFirst();
                        counters.put(headChar, counters.get(headChar) - 1);
                    }
                }
                if (count + 1 == letters.get(c)) {
                    ++nLettersCompleted;
                }
                if (nLettersCompleted == letters.size()) {
                    int start = positions.peekFirst();
                    int end = positions.peekLast();
                    int window = end - start + 1;
                    if (minWindow == -1 || window < minWindow) {
                        minWindow = window;
                        minWindowStart = start;
                    }
                }
            }
        }
        return minWindow == -1 ? "" : s.substring(minWindowStart, minWindowStart + minWindow);
    }
}
