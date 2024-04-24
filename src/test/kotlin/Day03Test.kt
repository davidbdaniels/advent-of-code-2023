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
    fun testNotAdjacent_returnFalse() {
        val lines = listOf("..../", "123..")
        val number = createNumberObject(123, 3, arrayOf(1, 0))

        val result = day03.numberIsAdjacentToSymbol(number, lines)
        assertEquals(false, result)
    }

    private fun createNumberObject(value: Int, length: Int, startingPoint: Array<Int>): Number {
        val number = Number()
        number.value = value
        number.length = length
        number.startingPoint = startingPoint
        return number
    }
}
