package com.antaev.leetcode

object Regex {
    fun matches(s: String, p: String): Boolean {
        return matches(s, 0, p, 0)
    }

    private fun matches(s: String, si: Int, p: String, pi: Int): Boolean {
        if (si == s.length && pi == p.length)
            return true
        if (pi == p.length)
            return false
        if (si == s.length) {
            for (i in pi + 1 until p.length step 2) {
                if (p[i] != '*')
                    return false
            }
            return p.last() == '*'
        }
        val pc = p[pi]
        val isStar = pi + 1 < p.length && p[pi + 1] == '*'
        return if (isStar) {
            ((pc == '.' || pc == s[si]) && (matches(s, si + 1, p, pi))) || matches(s, si, p, pi + 2)
        } else {
            (pc == '.' || pc == s[si]) && matches(s, si + 1, p, pi + 1)
        }
    }
}