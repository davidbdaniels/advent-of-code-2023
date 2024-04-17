package org.example

class Day02 {

    fun addIds(possibleGameIds: List<Int>): Int {
        var sum: Int = 0
        for (gameId in possibleGameIds) {
            sum += gameId
        }
        return sum
    }

    fun determinePossibleGameId(line: String, cubes: CubeTrio): Int {
        val isPossible = isPossibleGame(line, cubes)
        val gameId = getGameId(line, isPossible)
        return gameId
    }

    private fun isPossibleGame(line: String, cubes: CubeTrio): Boolean {
        val colorCountList = createColorCountList(line)
        return !anyColorIsGreaterThanMaxCount(colorCountList, cubes)
    }

    private fun anyColorIsGreaterThanMaxCount(
                colorCountList: List<CubeTrio>, cubes: CubeTrio): Boolean {
        // TODO - Implement this method
        return false
    }

    private fun createColorCountList(line: String): List<CubeTrio> {
        return listOf(
            CubeTrio(1,0,2),
            CubeTrio(2,1,4),
            CubeTrio(7,0,5),
            CubeTrio(2,1,5),
        )
    }

    private fun getGameId(line: String, isPossible: Boolean): Int {
        if (isPossible) {
            val firstDigit = line.substring(5,6)
            val secondDigit = line.substring(6,7)
            val thirdDigit = line.substring(7,8)
            val fourthDigit = line.substring(8,9)

            return if (firstDigit.toIntOrNull() == null) {
                0
            } else if (firstDigit.toIntOrNull() is Int && secondDigit.toIntOrNull() == null) {
                firstDigit.toIntOrNull()!!
            } else if (firstDigit.toIntOrNull() is Int && secondDigit.toIntOrNull() is Int && thirdDigit.toIntOrNull() == null) {
                (firstDigit + secondDigit).toInt()
            } else if (firstDigit.toIntOrNull() is Int && secondDigit.toIntOrNull() is Int && thirdDigit.toIntOrNull() is Int && fourthDigit.toIntOrNull() == null) {
                (firstDigit + secondDigit + thirdDigit).toInt()
            } else {
                0
            }
        } else {
            return 0
        }
    }
}

class Game() {
    val cubeTrioList: List<CubeTrio> = listOf()
}

class CubeTrio(r: Int, g: Int, b: Int) {
    val redCube: Cube = Cube("red", r)
    val greenCube: Cube = Cube("green", g)
    val blueCube: Cube = Cube("blue", b)
}

class Cube(s: String, i: Int) {
    val color: String = s
    val count: Int = i
}
