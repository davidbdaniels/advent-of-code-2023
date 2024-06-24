import org.example.Day04
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day04Test {
    private val day04 = Day04()

    @Test
    fun testConvertWinningNumberCountToCardPoints_when0_return0() {
        assertEquals(0, day04.convertToCardPoints(0))
    }

    @Test
    fun testConvertWinningNumberCountToCardPoints_when1_return1() {
        assertEquals(1, day04.convertToCardPoints(1))
    }

    @Test
    fun testConvertWinningNumberCountToCardPoints_when2_return2() {
        assertEquals(2, day04.convertToCardPoints(2))
    }

    @Test
    fun testConvertWinningNumberCountToCardPoints_when3_return4() {
        assertEquals(4, day04.convertToCardPoints(3))
    }

    @Test
    fun testConvertWinningNumberCountToCardPoints_when4_return8() {
        assertEquals(8, day04.convertToCardPoints(4))
    }

    @Test
    fun testConvertWinningNumberCountToCardPoints_when5_return16() {
        assertEquals(16, day04.convertToCardPoints(5))
    }

    @Test
    fun testGetTotalCards() {
        val map = mapOf(1 to 3, 2 to 2, 3 to 1, 4 to 0)
        val result = day04.getTotalCards(map)
        assertEquals(10, result)
    }
}
