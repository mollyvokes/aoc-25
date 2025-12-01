package dayone

import org.scalatest.funsuite.AnyFunSuite

class DayOneTests extends AnyFunSuite {

  test("getTickCount should return the remainder of rawTicks divided by 100") {
    assert(DayOne.getTickCount(250) == 50)
    assert(DayOne.getTickCount(100) == 0)
    assert(DayOne.getTickCount(99) == 99)
    assert(DayOne.getTickCount(-101) == -1)
  }

  test("processRotations should correctly process rotation inputs") {
    val inputs = List("L68", "R48", "L5", "R60")
    val expected = List(-68, 48, -5, 60)
    assert(DayOne.processRotations(inputs) == expected)

    val emptyInputs = List.empty[String]
    assert(DayOne.processRotations(emptyInputs) == List())

    val invalidInputs = List("X100", "Y200")
    val expectedInvalid = List(0, 0)
    assert(DayOne.processRotations(invalidInputs) == expectedInvalid)
  }

}
