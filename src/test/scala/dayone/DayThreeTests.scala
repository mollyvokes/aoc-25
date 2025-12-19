package dayone

import daythree.{DayThree, DayThreeP2}
import org.scalatest.funsuite.AnyFunSuite

class DayThreeTests extends AnyFunSuite {

  val testBanks = List("987654321111111",
  "811111111111119",
  "234234234234278",
  "818181911112111"
  )

  val testIntList1 = List(8,1,8,1,8,1,9,1,1,1,1,2,1,1,1)
  val testIntList2 = List(8,1,1,1,1,1,1,1,1,1,1,1,1,1,9)
  val testIntList3 = List(2,3,4,2,3,4,2,3,4,2,3,4,2,7,8)

  test("joinJoltageString returns correct string from two ints") {
    assert(DayThree.joinJoltageString(1,2) == "12")
    assert(DayThree.joinJoltageString(3,2) == "32")
    assert(DayThree.joinJoltageString(183,32) == "18332")
  }

  test("findMaxIndex correctly returns index of highest int") {
    assert(DayThree.findMaxIndex(testIntList1) == 6)
    assert(DayThree.findMaxIndex(testIntList2) == 14)
    assert(DayThree.findMaxIndex(testIntList3) == 14)
  }

  test("largestJoltageOfBank returns correct combined joltage") {
    assert(DayThree.largestJoltageOfBank(testIntList1) == "92")
    assert(DayThree.largestJoltageOfBank(testIntList2) == "89")
    assert(DayThree.largestJoltageOfBank(testIntList3) == "78")
  }

  // p2

  test("joinJoltageString returns correct string for list of ints") {
    assert(DayThreeP2.joinJoltageString(testIntList1) == "818181911112111")
  }
}
