package dayone

import daytwo.DayTwo
import org.scalatest.funsuite.AnyFunSuite
class DayTwoTests extends AnyFunSuite {

  test("correctly determines if a given number is invalid (has repeating pattern") {
    // invalid
    assert(DayTwo.isNumberInvalid(11))
    assert(DayTwo.isNumberInvalid(22))
    assert(DayTwo.isNumberInvalid(1010))
    assert(DayTwo.isNumberInvalid(1188511885))
    assert(DayTwo.isNumberInvalid(222222))
    assert(DayTwo.isNumberInvalid(446446))
    assert(DayTwo.isNumberInvalid(38593859))
    // valid
    assert(!DayTwo.isNumberInvalid(101))
    assert(!DayTwo.isNumberInvalid(1698522))
    assert(!DayTwo.isNumberInvalid(2121212118))
    assert(!DayTwo.isNumberInvalid(96))
    assert(!DayTwo.isNumberInvalid(9))
  }

  test("correctly finds beginning and end of the range") {
    assert(DayTwo.getRangeEnds("5542145-5582046") == (5542145, 5582046))
    assert(DayTwo.getRangeEnds("243-401") == (243, 401))
    assert(DayTwo.getRangeEnds("884211-917063") == (884211, 917063))
    assert(DayTwo.getRangeEnds("1174-1665") == (1174, 1665))
  }

  test("gets correct sum of the invalid numbers in a given range") {
    assert(DayTwo.sumOfInvalidInRange(11,22) == 33)
    assert(DayTwo.sumOfInvalidInRange(95, 115) == 99)
    assert(DayTwo.sumOfInvalidInRange(1698522, 1698528) == 0)
  }

  test("correctly determines if a number is invalid for p2 - any number of repeating sequences") {
    // invalid
    assert(DayTwo.isNumberInvalidP2(11))
    assert(DayTwo.isNumberInvalidP2(22))
    assert(DayTwo.isNumberInvalidP2(1010))
    assert(DayTwo.isNumberInvalidP2(1188511885))

    assert(DayTwo.isNumberInvalidP2(999))
    assert(DayTwo.isNumberInvalidP2(565656))
    assert(DayTwo.isNumberInvalidP2(824824824))
    assert(DayTwo.isNumberInvalidP2(2121212121))

    // valid
    assert(!DayTwo.isNumberInvalidP2(101))
    assert(!DayTwo.isNumberInvalidP2(1698522))
    assert(!DayTwo.isNumberInvalidP2(2121212118))
    assert(!DayTwo.isNumberInvalidP2(96))
    assert(!DayTwo.isNumberInvalidP2(9))
  }

  test("recursively splits string as expected") {
    assert(DayTwo.splitStringRec("1188511885", 5, List.empty) == List("11885", "11885"))
    assert(DayTwo.splitStringRec("212121211", 3, List.empty) == List("212", "121", "211"))
    assert(DayTwo.splitStringRec("565656", 2, List.empty) == List("56", "56", "56"))
    assert(DayTwo.splitStringRec("10001000", 4, List.empty) == List("1000", "1000"))
  }

}
