package day01

import java.io.BufferedReader
import java.io.InputStreamReader

enum class StringDigitToInt (val value: Int) {
    one(1),
    two(2),
    three(3),
    four(4),
    five(5),
    six(6),
    seven(7),
    eight(8),
    nine(9),
}

fun processLine(line: String) : Int {
    val digitOrWordPatter = Regex("(one|two|three|four|five|six|seven|eight|nine|\\d)")
//    kotlin regex do not support overlapping matches
//    https://discuss.kotlinlang.org/t/feature-request-regex-findall-with-overlap/27729
    var start = 0
    val allMatches = mutableListOf<String>()
    while (start < line.length) {
        val match = digitOrWordPatter.find(line, start)
        if (match!=null) {allMatches.add(match.value)}
        start += 1
    }
    val firstDigit = allMatches.first()
    val lastDigit = allMatches.last()
    val numberFirstDigit = firstDigit.toIntOrNull() ?: StringDigitToInt.valueOf(firstDigit).value
    val numberLastDigit = lastDigit.toIntOrNull() ?: StringDigitToInt.valueOf(lastDigit).value
    return numberFirstDigit * 10 + numberLastDigit
}

fun main() {
    val filePath = "/data01"
    val inputStream = object {}.javaClass.getResourceAsStream(filePath)

    BufferedReader(InputStreamReader(inputStream)).use { reader ->
        var result = 0
        for (line in reader.lines()) {
            result += processLine(line)
        }
        println("result: $result")
    }
}