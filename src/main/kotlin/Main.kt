package org.example

import java.io.File

const val INPUT_DIRECTORY = "advent-of-code_input-files"

fun main() {
//    day01Main()
//    day02Main()
//    day02bMain()
    day03Main()
}

fun day01Main() {
    val day01 = Day01()
    var finalAnswer = 0

    // Read a file and parse into separate lines
    val lines = File("$INPUT_DIRECTORY/Day1_Input.txt").readLines()

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
    val lines = File("$INPUT_DIRECTORY/Day02_Input.txt").readLines()

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

fun day02bMain() {

    val day02 = Day02()
    val day02b = Day02b()

    val powers: MutableList<Int> = mutableListOf()
    var sumOfPowers = 0

    // Read a file and parse into separate lines
    val lines = File("$INPUT_DIRECTORY/Day02_Input.txt").readLines()

    for (line in lines) {
        val maxCubes = day02b.determineMaximumCubesPerColor(line)
        val powerOfCubes = day02b.multiplySetOfCubes(maxCubes)
        powers.add(powerOfCubes)
    }

    sumOfPowers = day02.addIds(powers)
    println("Final Answer: $sumOfPowers")
}

fun day03Main() {

    // Read a file and parse into separate lines
    val lines = File("$INPUT_DIRECTORY/Day03_Input.txt").readLines()

    val day03 = Day03()
    val numbers = day03.identifyNumberAdjacentToSymbol(lines)

    var finalAnswer = 0
    var countOfAdjacentNumbers = 0

    for (number in numbers) {
        if (number.adjacentToSymbol) {
            finalAnswer += number.value
            countOfAdjacentNumbers += 1
        }
    }

    println("Count of Adjacent Numbers: $countOfAdjacentNumbers")
    println("Final Answer: $finalAnswer")
}
