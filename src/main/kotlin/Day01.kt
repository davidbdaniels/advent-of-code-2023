package org.example

class Day01 {

    fun calculateTwoDigitNumber(line: String): Int {

        val digitsLeftToRight = calculateFirstDigit(line)
        val digitsRightToLeft = calculateLastDigit(line)

        val firstDigit = digitsLeftToRight.first()
        val lastDigit = digitsRightToLeft.first()

        val onlyNumbers = firstDigit.toString() + lastDigit.toString()

        return getFirstAndLastDigits(onlyNumbers)
    }

    private fun calculateFirstDigit(line: String): String {

        var onlyNumbers = ""
        var numberAsWord = ""
        var charIndex = 0

        for (char in line) {

            if (isDigit(char)) {
                // Append the digit to a String
                onlyNumbers += char
                numberAsWord = ""

            } else if ((isFirstLetter(char)) or (numberAsWord != "")) {
                // Convert the word to a digit and append to a String
                numberAsWord += char
                when (numberAsWord) {
                    "one"   -> {onlyNumbers += "1"; numberAsWord = ""}
                    "two"   -> {onlyNumbers += "2"; numberAsWord = ""}
                    "three" -> {onlyNumbers += "3"; numberAsWord = ""}
                    "four"  -> {onlyNumbers += "4"; numberAsWord = ""}
                    "five"  -> {onlyNumbers += "5"; numberAsWord = ""}
                    "six"   -> {onlyNumbers += "6"; numberAsWord = ""}
                    "seven" -> {onlyNumbers += "7"; numberAsWord = ""}
                    "eight" -> {onlyNumbers += "8"; numberAsWord = ""}
                    "nine"  -> {onlyNumbers += "9"; numberAsWord = ""}
                    // Edge Cases
                    "fone"  -> {onlyNumbers += "1"; numberAsWord = ""}
                }

                when (numberAsWord.length) {
                    2 -> {
                        numberAsWord = clearTwoLetterNonMatches(numberAsWord)
                    }
                    3 -> {
                        numberAsWord = clearThreeLetterNonMatches(numberAsWord)
                    }
                    4 -> {
                        numberAsWord = clearFourLetterNonMatches(numberAsWord)
                    }
                }
            }
            charIndex++
        }

        return onlyNumbers
    }

    private fun calculateLastDigit(line: String): String {

        var onlyNumbers = ""
        var numberAsWord = ""
        var charIndex = 0

        val reversedLine = line.reversed()

        for (char in reversedLine) {

            if (isDigit(char)) {
                // Append the digit to a String
                onlyNumbers += char
                numberAsWord = ""

            } else if ((isLastLetter(char)) or (numberAsWord != "")) {
                // Convert the word to a digit and append to a String
                numberAsWord += char
                when (numberAsWord) {
                    "eno"   -> {onlyNumbers += "1"; println("one"); numberAsWord = ""}
                    "owt"   -> {onlyNumbers += "2"; println("two"); numberAsWord = ""}
                    "eerht" -> {onlyNumbers += "3"; println("three"); numberAsWord = ""}
                    "ruof"  -> {onlyNumbers += "4"; println("four"); numberAsWord = ""}
                    "evif"  -> {onlyNumbers += "5"; println("five"); numberAsWord = ""}
                    "xis"   -> {onlyNumbers += "6"; println("six"); numberAsWord = ""}
                    "neves" -> {onlyNumbers += "7"; println("seven"); numberAsWord = ""}
                    "thgie" -> {onlyNumbers += "8"; println("eight"); numberAsWord = ""}
                    "enin"  -> {onlyNumbers += "9"; println("nine"); numberAsWord = ""}
                    // Edge Cases
                    "neerht"-> {onlyNumbers += "3"; println("threen"); numberAsWord = ""}
                    "nevif" -> {onlyNumbers += "5"; println("fiven"); numberAsWord = ""}
                    "nenin" -> {onlyNumbers += "9"; println("ninen"); numberAsWord = ""}
                }

                when (numberAsWord.length) {
                    2 -> {
                        numberAsWord = clearTwoLetterNonMatchesBackward(numberAsWord)
                    }
                    3 -> {
                        numberAsWord = clearThreeLetterNonMatchesBackward(numberAsWord)
                    }
                    4 -> {
                        numberAsWord = clearFourLetterNonMatchesBackward(numberAsWord)
                    }
                    5 -> {
                        numberAsWord = clearFiveLetterNonMatchesBackward(numberAsWord)
                    }
                }
            }
            charIndex++
        }

        return onlyNumbers
    }

    private fun getFirstAndLastDigits(onlyNumbers: String): Int {
        var twoDigitNumber = 0

        if (onlyNumbers.length == 1) {
            twoDigitNumber = onlyNumbers.toInt() * 11
        } else if (onlyNumbers.length > 1) {
            val lastDigit = onlyNumbers.length - 1
            twoDigitNumber += onlyNumbers.substring(0, 1).toInt() * 10
            twoDigitNumber += onlyNumbers.substring(lastDigit, lastDigit + 1).toInt()
        }

        return twoDigitNumber
    }

    private fun clearTwoLetterNonMatches(numberAsWord: String): String {
        if (!isFirstTwoLetters(numberAsWord)) {
            val secondChar = numberAsWord.substring(1,2).toCharArray().get(0)
            if (isFirstLetter(secondChar)) {
                return secondChar.toString()
            } else {
                return ""
            }
        } else {
            return numberAsWord
        }
    }

    private fun clearThreeLetterNonMatches(numberAsWord: String): String {
        if (!isFirstThreeLetters(numberAsWord)) {
            val thirdChar = numberAsWord.substring(2,3).toCharArray().get(0)
            if (isFirstLetter(thirdChar)) {
                return thirdChar.toString()
            } else {
                return ""
            }
        } else {
            return numberAsWord
        }
    }

    private fun clearFourLetterNonMatches(numberAsWord: String): String {
        if (!isFirstFourLetters(numberAsWord)) {
            val fourthChar = numberAsWord.substring(3,4).toCharArray().get(0)
            if (isFirstLetter(fourthChar)) {
                return fourthChar.toString()
            } else {
                return ""
            }
        } else {
            return numberAsWord
        }
    }

    fun clearTwoLetterNonMatchesBackward(numberAsWord: String): String {
        if (!isLastTwoLetters(numberAsWord)) {
            val secondChar = numberAsWord.substring(1, 2).toCharArray().get(0)
            if (isLastLetter(secondChar)) {
                return secondChar.toString()
            } else {
                return ""
            }
        } else {
            return numberAsWord
        }
    }

    private fun clearThreeLetterNonMatchesBackward(numberAsWord: String): String {
        if (!isLastThreeLetters(numberAsWord)) {
            val thirdChar = numberAsWord.substring(2,3).toCharArray().get(0)
            if (isLastLetter(thirdChar)) {
                return thirdChar.toString()
            } else {
                return ""
            }
        } else {
            return numberAsWord
        }
    }

    private fun clearFourLetterNonMatchesBackward(numberAsWord: String): String {
        if (!isLastFourLetters(numberAsWord)) {
            val fourthChar = numberAsWord.substring(3,4).toCharArray().get(0)
            if (isLastLetter(fourthChar)) {
                return fourthChar.toString()
            } else {
                return ""
            }
        } else {
            return numberAsWord
        }
    }

    private fun clearFiveLetterNonMatchesBackward(numberAsWord: String): String {
        if (!isLastFiveLetters(numberAsWord)) {
            val fifthChar = numberAsWord.substring(4,5).toCharArray().get(0)
            if (isLastLetter(fifthChar)) {
                return fifthChar.toString()
            } else {
                return ""
            }
        } else {
            return numberAsWord
        }
    }

    private fun isDigit(char: Char): Boolean {
        return char in '0'..'9'
    }

    private fun isFirstLetter(char: Char): Boolean {
        // Return true if the char is a letter that is the first letter of a single-digit number
        return char in arrayOf('o', 't', 'f', 's', 'e', 'n')
    }

    private fun isFirstTwoLetters(letters: String): Boolean {
        return letters in arrayOf("on", "tw", "th", "fo", "fi", "si", "se", "ei", "ni")
    }

    private fun isFirstThreeLetters(letters: String): Boolean {
        return letters in arrayOf("thr", "fou", "fiv", "sev", "eig", "nin", "fon")
    }

    private fun isFirstFourLetters(letters: String): Boolean {
        return letters in arrayOf("thre", "seve", "eigh")
    }

    private fun isLastLetter(char: Char): Boolean {
        // Return true if the char is a letter that is the last letter of a single-digit number
        return char in arrayOf('e', 'o', 'r', 'x', 'n', 't')
    }

    private fun isLastTwoLetters(letters: String): Boolean {
        return letters in arrayOf("en", "ow", "ee", "ru", "ev", "xi", "ne", "th")
    }

    private fun isLastThreeLetters(letters: String): Boolean {
        return letters in arrayOf("eer", "ruo", "evi", "nev", "thg", "eni", "nee", "nev", "nen")
    }

    private fun isLastFourLetters(letters: String): Boolean {
        return letters in arrayOf("eerh", "neve", "thgi", "neer", "nevi", "neni")
    }

    private fun isLastFiveLetters(letters: String): Boolean {
        return letters in arrayOf("neerh")
    }
}
