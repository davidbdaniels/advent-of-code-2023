package org.example

import java.io.File

const val INPUT_DIRECTORY = "advent-of-code_input-files"

fun main() {
    day05Main()
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

    val finalAnswer = day02.addIds(possibleGameIds)
    println("Final Answer: $finalAnswer")
}

fun day02bMain() {

    val day02 = Day02()
    val day02b = Day02b()

    val powers: MutableList<Int> = mutableListOf()

    // Read a file and parse into separate lines
    val lines = File("$INPUT_DIRECTORY/Day02_Input.txt").readLines()

    for (line in lines) {
        val maxCubes = day02b.determineMaximumCubesPerColor(line)
        val powerOfCubes = day02b.multiplySetOfCubes(maxCubes)
        powers.add(powerOfCubes)
    }

    val sumOfPowers = day02.addIds(powers)
    println("Final Answer: $sumOfPowers")
}

fun day03Main() {

    // Read a file and parse into separate lines
    val lines = File("$INPUT_DIRECTORY/Day03_Input.txt").readLines()

    val day03 = Day03()
    val numbers = day03.getNumbersAdjacentToSymbol(lines)

    var finalAnswer = 0
    var adjacentNumberCount = 0
    var nonAdjacentNumberCount = 0

    for (number in numbers) {
        if (number.adjacentToSymbol) {
            finalAnswer += number.value
            adjacentNumberCount += 1
        } else {
            nonAdjacentNumberCount += 1
        }
    }

    println("---------------------------------")
    println("Count of Adjacent Numbers: $adjacentNumberCount")
    println("Count of Non-Adjacent Numbers: $nonAdjacentNumberCount")
    println("---------------------------------")
    println("Final Answer: $finalAnswer")
    println("---------------------------------")
}

fun day03bMain() {

    // Read a file and parse into separate lines
    val lines = File("$INPUT_DIRECTORY/Day03_Input.txt").readLines()

    val day03 = Day03()
    val gearRatios = day03.getGearRatios(lines)

    var finalAnswer = 0

    for (gearRatio in gearRatios) {
        finalAnswer += gearRatio
    }

    println("---------------------------------")
    println("Final Answer: $finalAnswer")
    println("---------------------------------")
}

fun day04Main() {

    // Read a file and parse into separate lines
    val lines = File("$INPUT_DIRECTORY/Day04_Input.txt").readLines()

    val day04 = Day04()
    val cardPoints = day04.getCardPoints(lines)

    var finalAnswer = 0

    for (cardPoint in cardPoints) {
        finalAnswer += cardPoint
    }

    println("---------------------------------")
    println("Final Answer: $finalAnswer")
    println("---------------------------------")
}

fun day04bMain() {

    // Read a file and parse into separate lines
    val lines = File("$INPUT_DIRECTORY/Day04_Input_Example.txt").readLines()

    val day04 = Day04()
    val cardCounts = day04.getCardCountByLineNumber(lines)
    val finalAnswer = day04.getTotalCards(cardCounts)

    println("---------------------------------")
    println("Final Answer: $finalAnswer")
    println("---------------------------------")
}

fun day05Main() {

    // Read a file and parse into separate lines
    val lines = File("$INPUT_DIRECTORY/Day05_Input.txt").readLines()

    val day05 = Day05()
    val locationNumbers: MutableList<Int> = mutableListOf()

    val seedNumbers = day05.getInitialSeedNumbers(lines)
    for (seedNumber: Int in seedNumbers) {
        val locationNumber = day05.findLocationNumber(seedNumber, lines)
        locationNumbers.add(locationNumber)
    }

    val finalAnswer = 0

    println("---------------------------------")
    println("Final Answer: $finalAnswer")
    println("---------------------------------")
}
