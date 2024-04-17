import org.example.Day02
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Day02Test {

    private val day02 = Day02()

    @Test
    fun testAddZeroItems() {
        val inputList: List<Int> = listOf()
        val expected = 0
        Assertions.assertEquals(expected, day02.addIds(inputList))
    }

    @Test
    fun testAddOneItem() {
        val inputList: List<Int> = listOf(5)
        val expected = 5
        Assertions.assertEquals(expected, day02.addIds(inputList))
    }

    @Test
    fun testAddTwoItems() {
        val inputList: List<Int> = listOf(5,4)
        val expected = 9
        Assertions.assertEquals(expected, day02.addIds(inputList))
    }

    @Test
    fun testAddThreeItems() {
        val inputList: List<Int> = listOf(5,4,3)
        val expected = 12
        Assertions.assertEquals(expected, day02.addIds(inputList))
    }
}
