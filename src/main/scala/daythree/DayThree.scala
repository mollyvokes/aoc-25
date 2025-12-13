package daythree

import helpers.AdventOfCodeSolver

object DayThree extends AdventOfCodeSolver {

  def joinJoltageString(bat1: Int, bat2: Int): String = bat1.toString + bat2.toString

  def findMaxIndex(bank: List[Int]): Int = {
    bank.indexOf(bank.max)
  }

  def largestJoltageOfBank(bank: List[Int]): String = {
    val highestBatIndex = findMaxIndex(bank)
    if (highestBatIndex == bank.length - 1) {
      // it's at the end so now need a number from before
      joinJoltageString(bank(findMaxIndex(bank.slice(0, highestBatIndex))), bank(highestBatIndex))
    } else {
      val rightBats = bank.slice(highestBatIndex + 1, bank.length)
      joinJoltageString(
        bank(highestBatIndex),
        rightBats(findMaxIndex(rightBats))
      )
    }
  }

  def main(args: Array[String]): Unit = {

    val inputLines = readInput("daythree.txt", None)

    val maxJolts = for (bank <- inputLines) yield {
      largestJoltageOfBank(bank.map(_.toString.toInt).toList).toInt
    }

    print(s"the max jolts from all the banks is ${maxJolts.sum}")

  }

}
