import org.example.Day03
import org.example.Number
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day03Test {

    private val day03 = Day03()

    @Test
    fun testDiagonallyAboveLeft() {
        val lines = listOf("*...", ".12.")
        val number = createNumberObject(12, 2, arrayOf(1, 1))

        val result = day03.numberIsAdjacentToSymbol(number, lines)
        assertEquals(true, result)
    }

    @Test
    fun testDiagonallyAboveRight() {
        val lines = listOf("...*", ".12.")
        val number = createNumberObject(12, 2, arrayOf(1, 1))

        val result = day03.numberIsAdjacentToSymbol(number, lines)
        assertEquals(true, result)
    }

    @Test
    fun testDiagonallyBelowLeft() {
        val lines = listOf(".12.", "*...")
        val number = createNumberObject(12, 2, arrayOf(0, 1))

        val result = day03.numberIsAdjacentToSymbol(number, lines)
        assertEquals(true, result)
    }

    @Test
    fun testDiagonallyBelowRight() {
        val lines = listOf(".12.", "...*")
        val number = createNumberObject(12, 2, arrayOf(0, 1))

        val result = day03.numberIsAdjacentToSymbol(number, lines)
        assertEquals(true, result)
    }

    @Test
    fun testDiagonallyAboveLeft_3_Digits() {
        val lines = listOf("*....", ".123.")
        val number = createNumberObject(123, 3, arrayOf(1, 1))

        val result = day03.numberIsAdjacentToSymbol(number, lines)
        assertEquals(true, result)
    }

    @Test
    fun testDiagonallyAboveRight_3_Digits() {
        val lines = listOf("....*", ".123.")
        val number = createNumberObject(123, 3, arrayOf(1, 1))

        val result = day03.numberIsAdjacentToSymbol(number, lines)
        assertEquals(true, result)
    }

    @Test
    fun testDiagonallyBelowLeft_3_Digits() {
        val lines = listOf(".123.", "*....")
        val number = createNumberObject(123, 3, arrayOf(0, 1))

        val result = day03.numberIsAdjacentToSymbol(number, lines)
        assertEquals(true, result)
    }

    @Test
    fun testDiagonallyBelowRight_3_Digits() {
        val lines = listOf(".123.", "....*")
        val number = createNumberObject(123, 3, arrayOf(0, 1))

        val result = day03.numberIsAdjacentToSymbol(number, lines)
        assertEquals(true, result)
    }

    @Test
    fun testImmediatelyAbove_1() {
        val lines = listOf(".*...", ".123.")
        val number = createNumberObject(123, 3, arrayOf(1, 1))

        val result = day03.numberIsAdjacentToSymbol(number, lines)
        assertEquals(true, result)
    }

    @Test
    fun testImmediatelyAbove_2() {
        val lines = listOf("..*..", ".123.")
        val number = createNumberObject(123, 3, arrayOf(1, 1))

        val result = day03.numberIsAdjacentToSymbol(number, lines)
        assertEquals(true, result)
    }

    @Test
    fun testImmediatelyAbove_3() {
        val lines = listOf("...*.", ".123.")
        val number = createNumberObject(123, 3, arrayOf(1, 1))

        val result = day03.numberIsAdjacentToSymbol(number, lines)
        assertEquals(true, result)
    }

    @Test
    fun testImmediatelyBelow_1() {
        val lines = listOf(".123.", ".*...")
        val number = createNumberObject(123, 3, arrayOf(0, 1))

        val result = day03.numberIsAdjacentToSymbol(number, lines)
        assertEquals(true, result)
    }

    @Test
    fun testImmediatelyBelow_2() {
        val lines = listOf(".123.", "..*..")
        val number = createNumberObject(123, 3, arrayOf(0, 1))

        val result = day03.numberIsAdjacentToSymbol(number, lines)
        assertEquals(true, result)
    }

    @Test
    fun testImmediatelyBelow_3() {
        val lines = listOf(".123.", "...*.")
        val number = createNumberObject(123, 3, arrayOf(0, 1))

        val result = day03.numberIsAdjacentToSymbol(number, lines)
        assertEquals(true, result)
    }

    @Test
    fun testDiagonallyBelowLeft_3_Digits_onEdgeOfLine() {
        val lines = listOf(".123", "*...")
        val number = createNumberObject(123, 3, arrayOf(0, 1))

        val result = day03.numberIsAdjacentToSymbol(number, lines)
        assertEquals(true, result)
    }

    @Test
    fun testFullLine_diagonallyAboveLeft_hyphen_492() {
        val lines = listOf(
            "........249....291...........448.622..228.......308.........189...............629........-...................*............594..127......782.",
            "..................*173..817.....................*.......91.....*..#................*649...492...400.........17...878.....*..........950.....")
        val number = createNumberObject(492, 3, arrayOf(1, 90))

        val result = day03.numberIsAdjacentToSymbol(number, lines)
        assertEquals(true, result)
    }

    @Test
    fun testNotAdjacent_returnFalse() {
        val lines = listOf("..../", "123..")
        val number = createNumberObject(123, 3, arrayOf(1, 0))

        val result = day03.numberIsAdjacentToSymbol(number, lines)
        assertEquals(false, result)
    }

    @Test
    fun testNotAdjacent_endOfLine_returnFalse() {
        val lines = listOf("....", ".686", "....")
        val number = createNumberObject(686, 3, arrayOf(1, 1))

        val result = day03.numberIsAdjacentToSymbol(number, lines)
        assertEquals(false, result)
    }

    @Test
    fun testAdjacent_endOfLine_returnTrue() {
        val lines = listOf("*...", ".395", "....")
        val number = createNumberObject(395, 3, arrayOf(1, 1))

        val result = day03.numberIsAdjacentToSymbol(number, lines)
        assertEquals(true, result)
    }

    @Test
    fun testAdjacent_diagonallyBelowLeft_endOfLine_returnTrue() {
        val lines = listOf("....", ".844", "*...")
        val number = createNumberObject(844, 3, arrayOf(1, 1))

        val result = day03.numberIsAdjacentToSymbol(number, lines)
        assertEquals(true, result)
    }

    @Test
    fun testAdjacent_diagonallyBelowRight_startOfLine_returnTrue() {
        val lines = listOf("....", "534.", ".../")
        val number = createNumberObject(534, 3, arrayOf(1, 0))

        val result = day03.numberIsAdjacentToSymbol(number, lines)
        assertEquals(true, result)
    }

    @Test
    fun testFindNumberAtLocation_whenFirstDigit_returnAllThreeDigits() {
        val row = 0
        val col = 1
        val numbers = mutableListOf(
            createNumberObject(123, 3, arrayOf(0, 1)),
            createNumberObject(456, 3, arrayOf(1, 1)),
            createNumberObject(789, 3, arrayOf(2, 1))
        )

        val result = day03.findNumberAtLocation(row, col, numbers)
        assertEquals(123, result.value)
        assertEquals(3, result.length)
    }

    @Test
    fun testFindNumberAtLocation_whenSecondDigit_returnAllThreeDigits() {
        val row = 0
        val col = 2
        val numbers = mutableListOf(
            createNumberObject(123, 3, arrayOf(0, 1)),
            createNumberObject(456, 3, arrayOf(1, 1)),
            createNumberObject(789, 3, arrayOf(2, 1))
        )

        val result = day03.findNumberAtLocation(row, col, numbers)
        assertEquals(123, result.value)
        assertEquals(3, result.length)
    }

    @Test
    fun testFindNumberAtLocation_whenThirdDigit_returnAllThreeDigits() {
        val row = 0
        val col = 3
        val numbers = mutableListOf(
            createNumberObject(123, 3, arrayOf(0, 1)),
            createNumberObject(456, 3, arrayOf(1, 1)),
            createNumberObject(789, 3, arrayOf(2, 1))
        )

        val result = day03.findNumberAtLocation(row, col, numbers)
        assertEquals(123, result.value)
        assertEquals(3, result.length)
    }

    @Test
    fun testGetNumberPairAdjacentToGearSymbol() {
        val rowIndex = 1
        val line = "..*..."
        val lines = listOf(".964..", "..*...", "...241")
        val numbers = mutableListOf(
            createNumberObject(964, 3, arrayOf(0,1)),
            createNumberObject(241, 3, arrayOf(2,3)),
        )

        val result = day03.getNumberPairAdjacentToGearSymbol(line, rowIndex, lines, numbers)
        val expected = mutableListOf(964, 241)
        assertEquals(expected, result)
    }

    private fun createNumberObject(value: Int, length: Int, startingPoint: Array<Int>): Number {
        val number = Number()
        number.value = value
        number.length = length
        number.startingPoint = startingPoint
        return number
    }
}
