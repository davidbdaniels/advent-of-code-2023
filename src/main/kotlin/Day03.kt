package org.example

class Day03 {

    fun getNumbersAdjacentToSymbol(lines: List<String>): List<Number> {

        val numbers: MutableList<Number> = mutableListOf()

        for ((lineIndex, line: String) in lines.withIndex()) {
            println("Line $lineIndex: $line")
            addNumbersToList(line, numbers, lineIndex)
        }

        for (number in numbers) {
            number.adjacentToSymbol = numberIsAdjacentToSymbol(number, lines)
            if (!number.adjacentToSymbol) {
                println("Non-Adjacent: ${number.value}")
            }
        }

        return numbers
    }

    private fun addNumbersToList(
        line: String,
        numbers: MutableList<Number>,
        lineIndex: Int
    ) {
        var number = Number()
        var numberString = ""
        var charIndex = 0
        var previousCharIsDigit: Boolean = false

        for (char in line) {

            if (previousCharIsDigit) {
                if (!char.isDigit()) {
                    number.value = numberString.toInt()
                    numbers.add(number)
                }
            } else {
                number = Number()
                number.length = 0
                numberString = ""
            }

            if (char.isDigit()) {
                numberString += char.toString()
                number.length += 1
                if (!previousCharIsDigit) {
                    number.startingPoint = arrayOf(lineIndex, charIndex)
                }
                previousCharIsDigit = true

            } else {
                previousCharIsDigit = false
            }

            charIndex += 1
        }
    }

    fun numberIsAdjacentToSymbol(number: Number, lines: List<String>): Boolean {
        val currentRow = isAdjacentOnCurrentRow(number, lines)
        val previousRow = isAdjacentOnPreviousRow(number, lines)
        val nextRow = isAdjacentOnNextRow(number, lines)

        return currentRow || previousRow || nextRow
    }

    private fun isAdjacentOnCurrentRow(number: Number, lines: List<String>): Boolean {
        return isOnImmediateLeft(number, lines)
                || isOnImmediateRight(number, lines)
    }

    private fun isAdjacentOnPreviousRow(number: Number, lines: List<String>): Boolean {
        return isImmediatelyAbove(number, lines)
                || isDiagonallyAboveLeft(number, lines)
                || isDiagonallyAboveRight(number, lines)
    }

    private fun isAdjacentOnNextRow(number: Number, lines: List<String>): Boolean {
        return isImmediatelyBelow(number, lines)
                || isDiagonallyBelowLeft(number, lines)
                || isDiagonallyBelowRight(number, lines)
    }

    private fun isImmediatelyAbove(number: Number, lines: List<String>): Boolean {

        val symbolIsAboveFirstDigit = isSymbol(number.startingPoint[0] - 1, number.startingPoint[1], lines)
        val symbolIsAboveSecondDigit = isSymbol(number.startingPoint[0] - 1, number.startingPoint[1] + 1, lines)
        val symbolIsAboveThirdDigit = isSymbol(number.startingPoint[0] - 1, number.startingPoint[1] + 2, lines)

        return when (number.length) {
            3 -> symbolIsAboveFirstDigit || symbolIsAboveSecondDigit || symbolIsAboveThirdDigit
            2 -> symbolIsAboveFirstDigit || symbolIsAboveSecondDigit
            1 -> symbolIsAboveFirstDigit
            else -> throw Exception("The number has an unexpected length. It must be 1, 2, or 3 digits in length. " +
                    "Number value: ${number.value}, Number length: ${number.length}")
        }
    }

    private fun isDiagonallyAboveLeft(number: Number, lines: List<String>): Boolean {
        val rowIndex = number.startingPoint[0] - 1
        val colIndex = number.startingPoint[1] - 1

        return isSymbol(rowIndex, colIndex, lines)
    }

    private fun isDiagonallyAboveRight(number: Number, lines: List<String>): Boolean {
        val rowIndex = number.startingPoint[0] - 1
        val colIndex =  number.startingPoint[1] + number.length

        return isSymbol(rowIndex, colIndex, lines)
    }

    private fun isImmediatelyBelow(number: Number, lines: List<String>): Boolean {

        val symbolIsBelowFirstDigit = isSymbol(number.startingPoint[0] + 1, number.startingPoint[1], lines)
        val symbolIsBelowSecondDigit = isSymbol(number.startingPoint[0] + 1, number.startingPoint[1] + 1, lines)
        val symbolIsBelowThirdDigit = isSymbol(number.startingPoint[0] + 1, number.startingPoint[1] + 2, lines)

        return when (number.length) {
            3 -> symbolIsBelowFirstDigit || symbolIsBelowSecondDigit || symbolIsBelowThirdDigit
            2 -> symbolIsBelowFirstDigit || symbolIsBelowSecondDigit
            1 -> symbolIsBelowFirstDigit
            else -> throw Exception("The number has an unexpected length. It must be 1, 2, or 3 digits in length. " +
                    "Number value: ${number.value}, Number length: ${number.length}")
        }
    }

    private fun isDiagonallyBelowLeft(number: Number, lines: List<String>): Boolean {
        val rowIndex = number.startingPoint[0] + 1
        val colIndex = number.startingPoint[1] - 1

        return isSymbol(rowIndex, colIndex, lines)
    }

    private fun isDiagonallyBelowRight(number: Number, lines: List<String>): Boolean {
        val rowIndex = number.startingPoint[0] + 1
        val colIndex =  number.startingPoint[1] + number.length

        return isSymbol(rowIndex, colIndex, lines)
    }

    private fun isOnImmediateLeft(number: Number, lines: List<String>): Boolean {
        val rowIndexOriginal = number.startingPoint[0]
        val colIndexOriginal = number.startingPoint[1]

        return isSymbol(rowIndexOriginal, colIndexOriginal - 1, lines)
    }

    private fun isOnImmediateRight(number: Number, lines: List<String>): Boolean {
        val rowIndexOriginal = number.startingPoint[0]
        val colIndexOriginal = number.startingPoint[1]

        return isSymbol(rowIndexOriginal, colIndexOriginal + number.length, lines)
    }

    private fun isSymbol (row: Int, column: Int, lines: List<String>): Boolean {

        val maxRow = lines.size - 1
        val maxColumn = lines[0].length - 1

        if (row > maxRow || column > maxColumn || row < 0 || column < 0) {
            return false
        }
        return (!isDot(row, column, lines) && !isDigit(row, column, lines))
    }

    private fun isDot(row: Int, column: Int, lines: List<String>): Boolean {
        return lines[row][column] == '.'
    }

    private fun isDigit(row: Int, column: Int, lines: List<String>): Boolean {
        return lines[row][column].isDigit()
    }

    /*
     Methods for Day 3 Part 2 (Day03b)
     */

    fun getGearRatios(lines: List<String>): List<Int> {
        val gearRatios: MutableList<Int> = mutableListOf()
        val numbers: MutableList<Number> = mutableListOf()

        for ((lineIndex, line: String) in lines.withIndex()) {
            addNumbersToList(line, numbers, lineIndex)
        }

        for ((lineIndex, line: String) in lines.withIndex()) {
            println("Line $lineIndex: $line")
            val numberPair: List<Int> = getNumberPairAdjacentToGearSymbol(line, numbers)
            if (numberPair.isNotEmpty()) {
                val product = numberPair[0] * numberPair[1]
                gearRatios.add(product)
            }
        }

        return gearRatios
    }

    private fun getNumberPairAdjacentToGearSymbol(line: String, numbers: MutableList<Number>): List<Int> {
        val numberPair: MutableList<Int> = mutableListOf()

        for (char in line) {
            if (isGear(char)) {
                // TODO: Implement logic to find the two numbers adjacent to the gear symbol
            }
        }

        return numberPair
    }

    private fun isGear(char: Char): Boolean {
        return char == '*'
    }

    private fun getAdjacentNumber(row: Int, column: Int, lines: List<String>,
                                  numbers: MutableList<Number>): Number {

        val maxRow = lines.size - 1
        val maxColumn = lines[0].length - 1
        val number = Number()

        if (row > maxRow || column > maxColumn || row < 0 || column < 0) {
            return number
        }

        if (isDigit(row, column, lines)) {
            return findNumberAtLocation(row, column, numbers)
        } else {
            return number
        }
    }

    fun findNumberAtLocation(row: Int, column: Int, numbers: MutableList<Number>): Number {
//        for (number in numbers) {
//            if (number.startingPoint[0] == row) {
//                for (digit: Int = 0; digit < number.length; digit++) {
//                    if (number.startingPoint[1] + digit == column) {
//                        return number.value
//                    }
//                }
//            }
//        }

        // Get value of number at the given row and column
        val foundNumber = numbers.firstOrNull { number ->
            number.startingPoint[0] == row && IntRange(0, number.length - 1).any { digit ->
                number.startingPoint[1] + digit == column
            }
        }?: Number()

        return foundNumber
    }
}

class Number {

    var value: Int = 0
    var length: Int = 0
    var startingPoint: Array<Int> = arrayOf(0,0)
    var adjacentToSymbol: Boolean = false
}
