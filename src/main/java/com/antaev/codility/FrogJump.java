package com.antaev.codility;

class FrogJump {
    static int countJumps(int x, int y, int jump) {
        int distance = y - x;
        int fullJumps = distance / jump;
        return distance % jump == 0 ? fullJumps : fullJumps + 1;
    }
}
