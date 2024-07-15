import org.example.Day05
import org.junit.jupiter.api.Test

class Day05Test {

    private val day05 = Day05()

    @Test
    fun testGetMap() {
        val lines = listOf(
            "seeds: 929142010 467769747 2497466808 210166838 3768123711 33216796 1609270159 86969850 199555506 378609832 1840685500 314009711 1740069852 36868255 2161129344 170490105 2869967743 265455365 3984276455 31190888",
            "",
            "seed-to-soil map:",
            "15 9 74",
            "8 57 7",
            "46 64 79",
            "96 83 12",
            ""
        )

        val map = day05.getMap("seed-to-soil", lines)

        assert(map.size == 4)
        assert(map[15]?.destinationRange == 15)
        assert(map[15]?.sourceRange == 9)
        assert(map[15]?.rangeLength == 74)
        assert(map[8]?.destinationRange == 8)
        assert(map[8]?.sourceRange == 57)
        assert(map[8]?.rangeLength == 7)
        assert(map[46]?.destinationRange == 46)
        assert(map[46]?.sourceRange == 64)
        assert(map[46]?.rangeLength == 79)
        assert(map[96]?.destinationRange == 96)
        assert(map[96]?.sourceRange == 83)
        assert(map[96]?.rangeLength == 12)
    }
}
