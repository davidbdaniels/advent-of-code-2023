package org.example

class Day03 {

    fun identifyNumberAdjacentToSymbol(lines: List<String>): List<Number> {

        val numbers: MutableList<Number> = mutableListOf()
        for ((lineIndex, line: String) in lines.withIndex()) {

            println("Line $lineIndex: $line")

            var number = Number()
            var numValue = ""
            var length = 0
            var charIndex = 0
            var previousCharIsDigit: Boolean = false

            for (char in line) {

                if (previousCharIsDigit) {
                    if (!char.isDigit()) {
                        number.value = numValue.toInt()
                        number.length = length
                        numbers.add(number)
                        println("Line $lineIndex: Number: ${number.value}, Length: ${number.length}, Starting Point: ${number.startingPoint.toList()}")
                    }
                } else {
                    number = Number()
                    numValue = ""
                    length = 0
                }

                if (char.isDigit()) {
                    numValue += char.toString()
                    length += 1
                    if (!previousCharIsDigit) {
                        number.startingPoint = arrayOf(lineIndex, charIndex)
                    }
                    previousCharIsDigit = true

                } else {
                    previousCharIsDigit = false
                }

                charIndex+= 1
            }
        }

        for (number in numbers) {
            if (numberIsAdjacentToSymbol(number, lines)) {
                number.adjacentToSymbol = true
                println("Adjacent to symbol: ${number.value}")
            }
        }

        return numbers
    }

    fun numberIsAdjacentToSymbol(number: Number, lines: List<String>): Boolean {
        return isAdjacentOnCurrentRow(number, lines)
                || isAdjacentOnPreviousRow(number, lines)
                || isAdjacentOnNextRow(number, lines)
    }

    private fun isAdjacentOnCurrentRow(number: Number, lines: List<String>): Boolean {
        return isOnImmediateLeft(number, lines) || isOnImmediateRight(number, lines)
    }

    private fun isAdjacentOnPreviousRow(number: Number, lines: List<String>): Boolean {
        return isImmediatelyAbove(number, lines) || isDiagonallyAbove(number, lines)
    }

    private fun isAdjacentOnNextRow(number: Number, lines: List<String>): Boolean {
        return isImmediatelyBelow(number, lines) || isDiagonallyBelow(number, lines)
    }

    private fun isImmediatelyAbove(number: Number, lines: List<String>): Boolean {
        return isSymbol(number.startingPoint[0] - 1, number.startingPoint[1], lines)
                || isSymbol(number.startingPoint[0] - 1, number.startingPoint[1] + number.length - 2, lines)
                || isSymbol(number.startingPoint[0] - 1, number.startingPoint[1] + number.length - 1, lines)
                || isSymbol(number.startingPoint[0] - 1, number.startingPoint[1] + number.length, lines)
    }

    private fun isDiagonallyAbove(number: Number, lines: List<String>): Boolean {
        return isSymbol(number.startingPoint[0] - 1, number.startingPoint[1] - 1, lines)
                || isSymbol(number.startingPoint[0] - 1, number.startingPoint[1] + number.length + 1, lines)
    }

    private fun isImmediatelyBelow(number: Number, lines: List<String>): Boolean {
        return isSymbol(number.startingPoint[0] + 1, number.startingPoint[1], lines)
                || isSymbol(number.startingPoint[0] + 1, number.startingPoint[1] + number.length - 2, lines)
                || isSymbol(number.startingPoint[0] + 1, number.startingPoint[1] + number.length - 1, lines)
                || isSymbol(number.startingPoint[0] + 1, number.startingPoint[1] + number.length, lines)
    }

    private fun isDiagonallyBelow(number: Number, lines: List<String>): Boolean {
        return isSymbol(number.startingPoint[0] + 1, number.startingPoint[1] - 1, lines)
                || isSymbol(number.startingPoint[0] + 1, number.startingPoint[1] + number.length + 1, lines)
    }

    private fun isOnImmediateLeft(number: Number, lines: List<String>): Boolean {
        return isSymbol(number.startingPoint[0], number.startingPoint[1] - 1, lines)
    }

    private fun isOnImmediateRight(number: Number, lines: List<String>): Boolean {
        return isSymbol(number.startingPoint[0], number.startingPoint[1] + number.length, lines)
    }

    private fun isSymbol (row: Int, column: Int, lines: List<String>): Boolean {

        val maxRow = lines.size - 1
        val maxColumn = lines[0].length - 1

        if (row > maxRow || column > maxColumn || row < 0 || column < 0) {
            return false
        }
        return (!isDot(row, column, lines) && !isNumber(row, column, lines))
    }

    private fun isDot(row: Int, column: Int, lines: List<String>): Boolean {
        return lines[row][column] == '.'
    }

    private fun isNumber(row: Int, column: Int, lines: List<String>): Boolean {
        return lines[row][column].isDigit()
    }
}

class Number {

    var value: Int = 0
    var length: Int = 0
    var startingPoint: Array<Int> = arrayOf(0,0)
    var adjacentToSymbol: Boolean = false
}
