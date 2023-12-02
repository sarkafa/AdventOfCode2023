package day01

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val filePath = "/data01"
    val inputStream = object {}.javaClass.getResourceAsStream(filePath)

    BufferedReader(InputStreamReader(inputStream)).use { reader ->
        var result: Int = 0
        for (line in reader.lines()) {
            val firstDigit = line.firstOrNull { it.isDigit() }?.toString()?.toIntOrNull() ?: 0
            val lastDigit = line.lastOrNull { it.isDigit() }?.toString()?.toIntOrNull() ?: 0
            val number = firstDigit * 10 + lastDigit
            result += number
            println("result: $number")
        }
    }
}