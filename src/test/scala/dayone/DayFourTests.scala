package dayone

import dayfour.DayFour
import org.scalatest.funsuite.AnyFunSuite

class DayFourTests extends AnyFunSuite {

  test("test correctly counts the number of @'s in a list") {
    assert(DayFour.countSurroundingRolls("@@,,@,,@,") == 3)
  }

}
