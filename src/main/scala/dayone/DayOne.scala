package dayone

import helpers.AdventOfCodeSolver

/***
 * Rotation based puzzle:
 * 1. Take starting position
 * 2. Rotate based on instructions: L means minus numbers, R means plus numbers for any given number of ticks
 * 3. Count each time the dial points exactly at 0
 * 4. Total count of times the dial points at 0 is the answer
 */
object DayOne extends AdventOfCodeSolver {

  def getTickCount(rawTicks: Int): Int = rawTicks % 100

  def processRotations(rotationInputs: List[String]): List[Int] = {
    rotationInputs.map { input =>
      val direction = input.charAt(0)
      val rawTicks = input.substring(1).toInt
      val ticks = getTickCount(rawTicks)
      direction match {
        case 'L' => -ticks
        case 'R' => ticks
        case _ => 0
      }
    }
  }

  def main (args: Array[String]): Unit = {
    var dial: Int = 50
    var zeroCount = 0
    val inputLines = readInput("dayone.txt")

    val turns: List[Int] = processRotations(inputLines)

    turns foreach { t =>
      dial = dial + t
      if (dial < 0) {
        dial = 100 + dial
      } else if (dial > 99) {
        dial = dial - 100
      }
      if (dial == 0) {
        zeroCount = zeroCount + 1
      }
    }
    print(s"the password is $zeroCount")

  }

}
