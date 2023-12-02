package day02

import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * @param red number of red cubes
 * @param blue number of green cubes
 * @param green number of blue cubes
 * @return true if the combination of the cubes can satisfy the combination of 12 red cubes, 13 green cubes, and 14 blue cubes
 */
fun isDoable (red: Int, blue: Int, green: Int) : Boolean {
    return !((red > 12) or (blue > 14) or (green > 13))
}

fun processLine(line: String): Int {
    val (game, rounds) = line.split(':')
    val gameIndex = game.replace("Game ", "").toInt()
    for (round in rounds.split(';')) {
        val colors = round.split(',')
        val green = colors.find{it.contains("green", ignoreCase = true)}?.filter{it.isDigit()}?.toIntOrNull() ?: 0
        val red = colors.find{it.contains("red", ignoreCase = true)}?.filter{it.isDigit()}?.toIntOrNull() ?: 0
        val blue = colors.find{it.contains("blue", ignoreCase = true)}?.filter{it.isDigit()}?.toIntOrNull() ?: 0
        if (!isDoable(red, blue, green)) {
            return 0
        }
    }
    return gameIndex
}

fun main() {
    val filePath = "/data02"
    val inputStream = object {}.javaClass.getResourceAsStream(filePath)

    BufferedReader(InputStreamReader(inputStream)).use { reader ->
        var result = 0
        for (line in reader.lines()) {
            result += processLine(line)
        }
        println("result: $result")
    }
}
