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

    private fun isPossibleGame(line: String, maxCubes: CubeTrio): Boolean {
        val cubeTrios = createCubeTrios(line)
        return !anyColorIsGreaterThanMaxCount(cubeTrios, maxCubes)
    }

    private fun anyColorIsGreaterThanMaxCount(
        cubeTrios: List<CubeTrio>, maxCubes: CubeTrio): Boolean {

        val maxRedCount = maxCubes.redCube.count
        val maxGreenCount = maxCubes.greenCube.count
        val maxBlueCount = maxCubes.blueCube.count

        for (cubeTrio in cubeTrios) {
            if (cubeTrio.redCube.count > maxRedCount) {
                return true
            } else if (cubeTrio.greenCube.count > maxGreenCount) {
                return true
            } else if (cubeTrio.blueCube.count > maxBlueCount) {
                return true
            }
        }

        return false
    }

    private fun createCubeTrios(line: String): List<CubeTrio> {

        // TODO - Implement this method
        // This method should parse the line and create a list of CubeTrio objects
        // Each CubeTrio object should have 3 Cube objects (red, green, blue)

        // Example:
        // Parse the line by splitting on the semicolons (;)
        // For each element in the split array, split on the commas (,)
        // Ignore any numbers before the colon (:)

        val cubeTrioList: MutableList<CubeTrio> = mutableListOf()

        val twoHalvesOfLine = line.split(":")
        val cubeInfo = twoHalvesOfLine[1]
        val splitArray = cubeInfo.split(";")

        for (element in splitArray) {
            val splitElement = element.split(",")
            var redCube = 0
            var greenCube = 0
            var blueCube = 0

            for (i in splitElement.indices) {
                if (splitElement[i].contains("red")) {
                    redCube = parseNumericCharacters(splitElement[i]).toInt()
                }
                if (splitElement[i].contains("green")) {
                    greenCube = parseNumericCharacters(splitElement[i]).toInt()
                }
                if (splitElement[i].contains("blue")) {
                    blueCube = parseNumericCharacters(splitElement[i]).toInt()
                }
            }

            val cubeTrio = CubeTrio(redCube, greenCube, blueCube)
            cubeTrioList.add(cubeTrio)
        }

        return cubeTrioList
    }

    private fun parseNumericCharacters(input: String): String {
        return input.filter { it.isDigit() }
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
