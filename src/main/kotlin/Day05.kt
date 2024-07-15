package org.example

class Day05 {

    fun getInitialSeedNumbers(lines: List<String>): List<Int> {

        val seedStrings: List<String> = lines[0].split(" ")
        val seedNumbers: MutableList<Int> = mutableListOf()
        if (seedStrings.isNotEmpty()) {
            for (seedString in seedStrings) {
                if (seedString != "seeds:") {
                    seedNumbers.add(seedString.toInt())
                }
            }
        } else {
            throw IllegalArgumentException("List of seed numbers is empty")
        }
        return seedNumbers
    }

    fun getLowestLocationNumber(locationNumbers: List<Int>): Int {

        // Sort a list of integers in ascending order
        val sortedLocationNumbers = locationNumbers.sorted()

        if (locationNumbers.isNotEmpty()) {
            return sortedLocationNumbers[0]
        } else {
            throw IllegalArgumentException("List of location numbers is empty")
        }
    }

    fun findLocationNumber(seedNumber: Int, lines: List<String>): Int {
//        val soilNumber =
        convertSeedToSoil(seedNumber, lines)
//        val fertilizerNumber = convertSoilToFertilizer(soilNumber)
//        val waterNumber = convertFertilizerToWater(fertilizerNumber)
//        val lightNumber = convertWaterToLight(waterNumber)
//        val temperatureNumber = convertLightToTemperature(lightNumber)
//        val humidityNumber = convertTemperatureToHumidity(temperatureNumber)
//        val locationNumber = convertHumidityToLocation(humidityNumber)

//        return locationNumber
        return 0
    }

    private fun convertSeedToSoil(seedNumber: Int, lines: List<String>): Int {
//        val seedToSoilMap =
        getMap("seed-to-soil", lines)
        return findSoilNumber(seedNumber) //, seedToSoilMap)
    }

    private fun findSoilNumber(seedNumber: Int): Int {
        // TODO: Implement this method
        return seedNumber
    }

    fun getMap(mapName: String, lines: List<String>): Map<Int, SeedMapping> {

        val seedMap = mutableMapOf<Int, SeedMapping>()

        // Find the index of the line that contains the mapName
        val mapIndex = lines.indexOfFirst { it.contains(mapName) }

        for (x in 1 ..< lines.size) {

            val line = lines[mapIndex + x]
            if (line.isEmpty()) {
                break
            }

            val seedMappingNumbers = line.split(" ")
            val seedMapping = SeedMapping()

            seedMapping.destinationRange = seedMappingNumbers[0].toInt()
            seedMapping.sourceRange = seedMappingNumbers[1].toInt()
            seedMapping.rangeLength = seedMappingNumbers[2].toInt()

            seedMap[seedMapping.destinationRange] = seedMapping
        }

        return seedMap
    }
}

class SeedMapping {
    var destinationRange: Int = 0
    var sourceRange: Int = 0
    var rangeLength: Int = 0
}
