package org.example

import java.io.File

fun main() {
//    day01Main()
    day02Main()
}

fun day01Main() {
    val day01 = Day01()
    var finalAnswer = 0

    // Read a file and parse into separate lines
    val lines = File("input_files/Day1_Input.txt").readLines()

    for ((index, line: String) in lines.withIndex()) {
        println("Line $index: $line")
        val twoDigitNumber = day01.calculateTwoDigitNumber(line)
        println("Line $index: $twoDigitNumber");
        finalAnswer += twoDigitNumber
        println("Partial Sum: $finalAnswer")
    }
    println("Final Answer: $finalAnswer")
}

fun day02Main() {

    val day02 = Day02()
    var finalAnswer = 0
    val possibleGameIds: MutableList<Int> = mutableListOf()

    // Read a file and parse into separate lines
    val lines = File("input_files/Day02_Input.txt").readLines()

    val cubes: CubeTrio = CubeTrio(12,13,14)

    for ((index, line: String) in lines.withIndex()) {
        println("Line $index: $line")
        val possibleGameId = day02.determinePossibleGameId(line, cubes)
        possibleGameIds.add(possibleGameId)
        println("Possible Game ID: $possibleGameId")
    }

    finalAnswer = day02.addIds(possibleGameIds)
    println("Final Answer: $finalAnswer")
}
