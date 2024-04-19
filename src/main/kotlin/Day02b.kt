package org.example

class Day02b {

    val day02 = Day02()

    fun multiplySetOfCubes(setOfCubes: CubeTrio): Int {
        val power = setOfCubes.redCube.count * setOfCubes.greenCube.count * setOfCubes.blueCube.count
        return power
    }

    fun determineMaximumCubesPerColor(line: String): CubeTrio {
        val cubeTrios = day02.createCubeTrios(line)
        val maxCubes = findMaximumCubes(cubeTrios)
        return maxCubes
    }

    private fun findMaximumCubes(cubeTrios: List<CubeTrio>): CubeTrio {
        // TODO - Implement this method
        val redCounts: List<Int> = cubeTrios.map { it.redCube.count }
        val greenCounts: List<Int> = cubeTrios.map { it.greenCube.count }
        val blueCounts: List<Int> = cubeTrios.map { it.blueCube.count }

        // Return the maximum integer in each list
        val maxRedCount = redCounts.maxOrNull() ?: 0
        val maxGreenCount = greenCounts.maxOrNull() ?: 0
        val maxBlueCount = blueCounts.maxOrNull() ?: 0

        return CubeTrio(maxRedCount,maxGreenCount,maxBlueCount)
    }
}
