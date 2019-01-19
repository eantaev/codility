package com.antaev.com.antaev.leetcode

import java.lang.IllegalArgumentException
import java.lang.StringBuilder

object IntegerToRoman {
    data class Digit(val symbol: String, val value: Int)

    private val DigitI = Digit("I", 1)
    private val DigitM = Digit("M", 1000)
    val digits = arrayOf(
        DigitM,
        Digit("CM", 900),
        Digit("D", 500),
        Digit("CD", 400),
        Digit("C", 100),
        Digit("XC", 90),
        Digit("L", 50),
        Digit("XL", 40),
        Digit("X", 10),
        Digit("IX", 9),
        Digit("V", 5),
        Digit("IV", 4),
        DigitI
    )

    val symbolIndex = digits.associateByTo(HashMap()) { it.symbol }

    private fun nextDigit(v: Int): Digit {
        digits.forEach { digit ->
            if (digit.value <= v)
                return digit
        }
        return DigitI
    }

    fun roman(v: Int): String {
        val sb = StringBuilder()
        var u = v
        while (u != 0) {
            val d = nextDigit(u)
            val m = u / d.value
            u %= d.value
            repeat(m) { sb.append(d.symbol) }
        }
        return sb.toString()
    }

    fun parseRoman(s: String): Int {
        var v = 0
        var lastDigit = DigitM
        for (c in s) {
            val d = symbolIndex[c.toString()] ?: throw IllegalArgumentException("digit $c is unknown")
            v += d.value
            if (lastDigit.value < d.value) {
                v -= 2 * lastDigit.value
            }
            lastDigit = d
        }
        return v
    }
}