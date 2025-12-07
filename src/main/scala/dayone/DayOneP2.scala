package dayone

import helpers.AdventOfCodeSolver

object DayOneP2 extends AdventOfCodeSolver {

  def getTickCount(rawTicks: Int): (Int, Int) = {
    (rawTicks % 100, rawTicks.abs / 100)
  }

  def processRotations(rotationInputs: List[String]): (List[Int], Int) = {
    var extraZeros = 0
    val rotations: List[Int] = rotationInputs.map { input =>
      val direction = input.charAt(0)
      val rawTicks = input.substring(1).toInt
      val (ticks, anyZeros) = getTickCount(rawTicks)
      extraZeros = extraZeros + anyZeros
      direction match {
        case 'L' => -ticks
        case 'R' => ticks
        case _ => 0
      }
    }
    (rotations, extraZeros)
  }

  def calculateZeroCount(turns: List[Int], zeroes: Int): Int = {
    val (_, zeroCount) = turns.foldLeft((50, zeroes)) {
      case ((dial, zeroCount), t) =>
        val dialWithTurns = dial + t
        // if dial was already at 0 or 100 then it won't have 'passed' either, so just return from here
        if (dial == 0 && dialWithTurns <= 0) {
          (100 + dialWithTurns, zeroCount)
        } else if (dial == 100 && dialWithTurns >= 100) {
          (dialWithTurns - 100, zeroCount)
        } else if (dialWithTurns < 0) {
          (100 + dialWithTurns, zeroCount + 1)
        } else if (dialWithTurns > 100) {
          (dialWithTurns - 100, zeroCount + 1)
        } else if (dialWithTurns == 0 | dialWithTurns == 100) {
          (dialWithTurns, zeroCount + 1)
        } else (dialWithTurns, zeroCount)
    }
    zeroCount
  }


  def main(args: Array[String]): Unit = {
    val inputLines = readInput("dayone.txt")

    val (turns, zeroCount) = processRotations(inputLines)

    print(s"the number of zeros found from 3 digit turns is: $zeroCount \n")

    val password = calculateZeroCount(turns, zeroCount)

    print(s"the password is $password")

  }


}
