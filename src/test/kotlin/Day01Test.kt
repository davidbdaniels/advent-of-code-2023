import org.example.Day01
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day01Test {

    private val day01 = Day01()

    @Test
    fun testInterruptedNumericWord() {
        val input = "se6ven"
        val expected = 66
        assertEquals(expected, day01.calculateTwoDigitNumber(input))
    }

    @Test
    fun testLongInput() {
        val input = "twofourtwoqxvpcjmnv3eighteightonetwo"
        val expected = 22
        assertEquals(expected, day01.calculateTwoDigitNumber(input))
    }

    @Test
    fun testOverlappingNumericWords48() {
        val input = "fouroneight"
        val expected = 48
        assertEquals(expected, day01.calculateTwoDigitNumber(input))
    }

    @Test
    fun testOverlappingNumericWords28a() {
        val input = "twooneight"
        val expected = 28
        assertEquals(expected, day01.calculateTwoDigitNumber(input))
    }

    @Test
    fun testOverlappingNumericWords28b() {
        val input = "twoneight"
        val expected = 28
        assertEquals(expected, day01.calculateTwoDigitNumber(input))
    }

    @Test
    fun testOverlappingNumericWords28c() {
        val input = "twooneeight"
        val expected = 28
        assertEquals(expected, day01.calculateTwoDigitNumber(input))
    }

    @Test
    fun testOverlappingNumericWords28d() {
        val input = "twonineight"
        val expected = 28
        assertEquals(expected, day01.calculateTwoDigitNumber(input))
    }

    @Test
    fun testOverlappingNumericWords68() {
        val input = "6twodndmhcgxlgbqbqndbbthnngblfgtzh5fouroneightrjp"
        val expected = 68
        assertEquals(expected, day01.calculateTwoDigitNumber(input))
    }

    @Test
    fun testOverlappingNumericWords17() {
        val input = "kzrdjnvxfone5sixsixrdnbvgtwo7"
        val expected = 17
        assertEquals(expected, day01.calculateTwoDigitNumber(input))
    }

    @Test
    fun testOverlappingNumericWords82() {
        val input = "gqeightwo"
        val expected = 82
        assertEquals(expected, day01.calculateTwoDigitNumber(input))
    }

    @Test
    fun testClearTwoLetterNonMatchesBackward_withMatch() {
        // First two letters of "two" backwards
        val input = "ow"
        val expected = "ow"
        assertEquals(expected, day01.clearTwoLetterNonMatchesBackward(input))
    }

    @Test
    fun testClearTwoLetterNonMatchesBackward_withPartialMatch() {
        // Partially matches a backwards number
        val input = "wo"
        val expected = "o"
        assertEquals(expected, day01.clearTwoLetterNonMatchesBackward(input))
    }

    @Test
    fun testClearTwoLetterNonMatchesBackward_withNoMatch_returnEmptyString() {
        // Does not match any backwards number
        val input = "zz"
        val expected = ""
        assertEquals(expected, day01.clearTwoLetterNonMatchesBackward(input))
    }

    @Test
    fun testEdgeCaseFone() {
        val input = "fone5"
        val expected = 15
        assertEquals(expected, day01.calculateTwoDigitNumber(input))
    }

    @Test
    fun testEdgeCaseThreen() {
        val input = "1threen"
        val expected = 13
        assertEquals(expected, day01.calculateTwoDigitNumber(input))
    }

    @Test
    fun testEdgeCaseFiven() {
        val input = "1fiven"
        val expected = 15
        assertEquals(expected, day01.calculateTwoDigitNumber(input))
    }

    @Test
    fun testEdgeCaseNinen() {
        val input = "1ninen"
        val expected = 19
        assertEquals(expected, day01.calculateTwoDigitNumber(input))
    }
}
