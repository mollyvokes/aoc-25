package daytwo

import helpers.AdventOfCodeSolver

import scala.annotation.tailrec

object DayTwo extends AdventOfCodeSolver {

  def isNumberInvalid(num: Long): Boolean = {
    if (num.toString.length % 2 == 0) {
      val numStr = num.toString
      val halfDigits = numStr.length / 2
      numStr.substring(0, halfDigits) == numStr.substring(halfDigits)
    } else {
      false
    }
  }

  @tailrec
  def splitStringRec(numStr: String, step: Int, splitSet: List[String]): List[String] = {
    if (numStr.nonEmpty) {
      splitStringRec(numStr.substring(step), step, splitSet.:+(numStr.substring(0, step)))
    } else splitSet
  }

  def isNumberInvalidP2(num: Long): Boolean = {
    val numStr = num.toString
    val numLen = numStr.length

    val anyMatches = for (i <- 2 to numLen) yield {
      val digitsToCheck = numLen / i
      if (numLen % digitsToCheck == 0) {
        val stringSplit = splitStringRec(numStr, digitsToCheck, List.empty)
        stringSplit.forall(_ == stringSplit.head)
      } else {
        false
      }
    }
    if (anyMatches.contains(true)) true else false
  }

  def getRangeEnds(range: String): (Long, Long) = {
    val splitPoint = range.indexOf("-")
    (range.substring(0,splitPoint).toLong, range.substring(splitPoint+1).toLong)
  }

  def sumOfInvalidInRange(start: Long, stop: Long): Long = {
    val invalids = for (i <- start to stop if isNumberInvalidP2(i)) yield {
      i
    }
    invalids.sum
  }

  def main(args: Array[String]): Unit = {

    val inputRanges = readInput("daytwo.txt", Some(","))

    val invalidSums = for (range <- inputRanges) yield {
      val (from, to) = getRangeEnds(range)
      sumOfInvalidInRange(from, to)
    }
    val invalidSum = invalidSums.sum

    print(s"the sum of the invalid numbers is: $invalidSum")

  }

}
