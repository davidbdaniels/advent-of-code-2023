package org.example

class Day04 {
    fun getCardPoints(lines: List<String>): List<Int> {
        val listOfCardPoints = mutableListOf<Int>()

        for ((index, line: String) in lines.withIndex()) {
            println("Line $index: $line")

            val winningNumberCount = getWinningNumberCount(line)
            println("Winning Number Count: $winningNumberCount")

            val cardPoints = convertToCardPoints(winningNumberCount)
            println("Card Points: $cardPoints")

            listOfCardPoints.add(cardPoints)
        }
        return listOfCardPoints
    }

    fun getWinningNumberCount(line: String): Int {

        var winningNumberMatches = 0
        val numberGroupings = line.split("|")

        var winningNumbers = numberGroupings[0].split(" ")
        var yourNumbers = numberGroupings[1].split(" ")

        // Remove empty elements from list of string
        winningNumbers = winningNumbers.filter { it.isNotEmpty() }
        yourNumbers = yourNumbers.filter { it.isNotEmpty() }

        println("Winning Numbers: $winningNumbers")
        println("Your Numbers: $yourNumbers")

        // Compare winning numbers to your numbers
        for (winningNumber in winningNumbers) {
            for (yourNumber in yourNumbers) {
                if (winningNumber == yourNumber) {
                    winningNumberMatches++
                }
            }
        }

        return winningNumberMatches
    }

    fun convertToCardPoints(winningNumberCount: Int): Int {

        var cardPoints = 0
        for (i: Int in 1..winningNumberCount) {
            cardPoints = if (i == 1) {
                1
            } else {
                cardPoints*2
            }
        }
        return cardPoints
    }
}
