package com.antaev.codility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepeatingSubsequence {
    public static int anytwo(String s) {
        int len = s.length();
        if (len < 4) {
            return 0;
        }
        Map<Character, Integer> latest = new HashMap<>();
        List<Map<Character, Integer>> prev = new ArrayList<>(len);
        for (int i = 0; i != len; ++i) {
            Character c = s.charAt(i);

            for (Map.Entry<Character, Integer> entry : latest.entrySet()) {
                Character a = entry.getKey();
                Integer apos = entry.getValue();
                if (a.equals(c)) {

                    if (prev.get(apos).get(a) != null) {
                        return 1;
                    }

                    for (Map.Entry<Character, Integer> e2: prev.get(apos).entrySet()) {
                        Character a2 = e2.getKey();
                        Integer a2pos =e2.getValue();
                        if (prev.get(a2pos).get(a2) != null) {
                            return 1;
                        }
                    }
                } else {
                    Integer prevC = prev.get(apos).get(c);
                    if (prevC != null) {
                        Integer prevA = prev.get(prevC).get(a);
                        if (prevA != null) {
                            return 1;
                        }
                    }
                }
            }

            prev.add(new HashMap<>(latest));
            latest.put(c, i);
        }
        System.out.println(prev);
        return 0;
    }
}
