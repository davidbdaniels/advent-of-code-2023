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

    fun getCardCountByLineNumber(lines: List<String>): Map<Int, Int>{
        val mapOfCardCounts = mutableMapOf<Int, Int>()

        for ((index, line: String) in lines.withIndex()) {
            println("Line $index: $line")
            val cardCountForLine = getCardCount(line)
            println("Card Count: $cardCountForLine")

            mapOfCardCounts[index+1] = cardCountForLine
        }
        return mapOfCardCounts
    }

    private fun getCardCount(line: String): Int {
        return getWinningNumberCount(line)
    }

    fun getTotalCards(cardCounts: Map<Int, Int>): Int {
        var totalCards = 0
        for ((lineNumber, cardCount) in cardCounts) {
            totalCards += cardCount
            if (cardCount > 0) {
                println("Line $lineNumber: $cardCount cards")

                // First Layer
                for (i in 1..cardCount) {
                    val additionalCards = cardCounts[lineNumber+i] ?: 0
                    totalCards += additionalCards
                    println("First Layer: Adding $additionalCards cards to total")

                    if (additionalCards == 0) {
                        continue
                    }

                    // Second Layer
                    for (j in 1 .. additionalCards) {
                        val additionalCards2 = cardCounts[lineNumber+i+j] ?: 0
                        totalCards += additionalCards2
                        println("Second Layer: Adding $additionalCards2 cards to total")

                        if (additionalCards2 == 0) {
                            continue
                        }

                        // Third Layer
                        for (k in 1 .. additionalCards2) {
                            val additionalCards3 = cardCounts[lineNumber+i+j+k] ?: 0
                            totalCards += additionalCards3
                            println("Third Layer: Adding $additionalCards3 cards to total")
                        }
                    }

                    // TODO: Need to add recursive logic here

                    // Card 1 has four matching numbers, so you win one copy each of the next four cards: cards 2, 3, 4, and 5.
                    // Your original card 2 has two matching numbers, so you win one copy each of cards 3 and 4.
                    // Your copy of card 2 also wins one copy each of cards 3 and 4.
                    // Your four instances of card 3 (one original and three copies) have two matching numbers, so you win four copies each of cards 4 and 5.
                }
            }
        }
        return totalCards
    }
}
