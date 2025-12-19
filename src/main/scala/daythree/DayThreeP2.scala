package daythree

import helpers.AdventOfCodeSolver

object DayThreeP2 extends AdventOfCodeSolver {

  def joinJoltageString(bats: List[Long]): String = bats.fold("")((x,y) => x + y.toString).toString

  def findMaxIndex(bank: List[Int]): Int = {
    bank.indexOf(bank.max)
  }

  def recBuildMaxString(maxBats: List[Long], bank: List[Long], remaining: Int): String = {
    if (remaining > 0) {
      val toFindFrom = bank.slice(0, bank.length - remaining + 1)
      val max = toFindFrom.max
      recBuildMaxString(maxBats ++ List(max), bank.slice(toFindFrom.indexOf(max) + 1, bank.length), remaining - 1)
    } else joinJoltageString(maxBats)
  }

  def main(args: Array[String]): Unit = {

    val inputLines = readInput("daythree.txt", None)

    val maxJolts: List[String] = inputLines.map(bank => recBuildMaxString(List.empty, bank.map(_.toString.toLong).toList, 12))

    print(s"the max jolts from all the banks is ${maxJolts.map(_.toLong).sum}")

  }

}
