package dayone

import dayfive.{DayFive, ValidIngredientRange}
import org.scalatest.funsuite.AnyFunSuite

class DayFiveTests extends AnyFunSuite {

  test("valid ingredient case class checks if in range correctly") {
    val ingredients1 = ValidIngredientRange("1-2")
    val ingredients2 = ValidIngredientRange("4325-54860")

    assert(ingredients1.start == 1)
    assert(ingredients1.end == 2)
    assert(ingredients1.inRange(2))
    assert(!ingredients1.inRange(74394))

    assert(ingredients2.start == 4325)
    assert(ingredients2.end == 54860)
    assert(ingredients2.inRange(4389))
    assert(!ingredients2.inRange(-5))
  }

  test("correctly splits on finding whitespace") {
    val testString = List(
      "1-2",
      "3-8",
      "",
      "3",
      "7",
      "8"
    )

    assert(DayFive.splitRangesAndIds(testString) == (
      List(
        ValidIngredientRange("1-2"),
        ValidIngredientRange("3-8")
      ),
      List("3","7","8")
    ))
  }

}
