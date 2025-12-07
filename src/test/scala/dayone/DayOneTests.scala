package dayone

import org.scalatest.funsuite.AnyFunSuite

class DayOneTests extends AnyFunSuite {

  test("getTickCount should return the remainder of rawTicks divided by 100") {
    assert(DayOne.getTickCount(250) == (50,2))
    assert(DayOne.getTickCount(100) == (0, 1))
    assert(DayOne.getTickCount(99) == (99, 0))
    assert(DayOne.getTickCount(-101) == (-1, 1))
  }

  test("processRotations should correctly process rotation inputs") {
    val inputs = List("L68", "R48", "L5", "R60")
    val expectedTicks = List(-68, 48, -5, 60)
    val expectedZeroesPassed = 0
    assert(DayOne.processRotations(inputs) == (expectedTicks, expectedZeroesPassed))

    val bigInputs = List("L168", "R548", "L7205", "R60")
    val expectedBigTicks = List(-68, 48, -5, 60)
    val expectedBigZeroesPassed = 78
    assert(DayOne.processRotations(bigInputs) == (expectedBigTicks, expectedBigZeroesPassed))

    val emptyInputs = List.empty[String]
    assert(DayOne.processRotations(emptyInputs) == (List(), 0))

    val invalidInputs = List("X100", "Y200")
    val expectedInvalid = List(0, 0)
    assert(DayOne.processRotations(invalidInputs) == (expectedInvalid, 3))

    val redditCheck = List("R1000", "L1000", "L50", "R1", "L1", "L1", "R1", "R100", "R1")
    val expectedRedditTicks = List(0, -0, -50, 1, -1, -1, 1, 0, 1)
    val expectedRedditZeroes = 21
    assert(DayOneP2.processRotations(redditCheck) == (expectedRedditTicks, expectedRedditZeroes))
  }

  test("calculate zero count should correctly get the password") {
    val turns = List(-68, -30, 48, -5, 60, -55, -1, -99, 14, -82)
    assert(DayOneP2.calculateZeroCount(turns, 0) == 6)

    val currentZeroes = 8
    assert(DayOneP2.calculateZeroCount(turns, currentZeroes) == 14)

    val redditFoundZeroes = 21
    val redditFoundTurns = List(0, -0, -50, 1, -1, -1, 1, 0, 1)
    assert(DayOneP2.calculateZeroCount(redditFoundTurns, redditFoundZeroes) == 25)

    val rt1 = List(-50, 50)
    assert(DayOneP2.calculateZeroCount(rt1, 0) == 1)
    val rt2 = List(-50, -50)
    assert(DayOneP2.calculateZeroCount(rt2, 0) == 1)
    val rt3 = List(50, 50)
    assert(DayOneP2.calculateZeroCount(rt3, 0) == 1)
    val rt4 = List(50, -50)
    assert(DayOneP2.calculateZeroCount(rt4, 0) == 1)

    val rt5 = List(-150, -50)
    assert(DayOneP2.calculateZeroCount(rt5, 0) == 2)
    val rt6 = List(-150, 50)
    assert(DayOneP2.calculateZeroCount(rt6, 0) == 2)
    val rt7 = List(150, -50)
    assert(DayOneP2.calculateZeroCount(rt7, 0) == 2)
    val rt8 = List(150, 50)
    assert(DayOneP2.calculateZeroCount(rt8, 0) == 2)
  }

}
