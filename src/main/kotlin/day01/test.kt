fun main() {
    val line = "oneight"
    val digitOrWordPattern = Regex("(?=(one|two|three|four|five|six|seven|eight|nine|\\d))")
    val matches = digitOrWordPattern.findAll(line)
    println(line)
    println()
    matches.forEach {println(it.value)}
}
