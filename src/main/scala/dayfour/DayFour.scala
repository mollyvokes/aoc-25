package dayfour

import helpers.AdventOfCodeSolver

object DayFour extends AdventOfCodeSolver {

  def countSurroundingRolls(sectionToCheck: String): Int = {
    sectionToCheck.count(_.equals('@')) - 1
  }

  def findRolls(diagram: List[String]): List[Int] = {
    val diagramLength = diagram.length
    val rowLength = diagram.head.length

    (0 until diagramLength).flatMap(i => {
      (0 until rowLength).map(j => {
        if (diagram(i)(j) == '@') {

          val lowerCol = if (j == 0) 0 else j - 1
          val upperCol = if (j == rowLength - 1) j + 1 else j + 2

          if (i == 0) {
            countSurroundingRolls(
              diagram(i).substring(lowerCol, upperCol) ++
              diagram(i + 1).substring(lowerCol, upperCol))
          } else if (i == diagramLength - 1) {
            countSurroundingRolls(
              diagram(i - 1).substring(lowerCol, upperCol) ++
              diagram(i).substring(lowerCol, upperCol))
          } else {
            countSurroundingRolls(
              diagram(i - 1).substring(lowerCol, upperCol) ++
              diagram(i).substring(lowerCol, upperCol) ++
              diagram(i + 1).substring(lowerCol, upperCol))
          }
        } else 10
      })
    })
  }.toList

  def main(args: Array[String]): Unit = {

    val inputLines = readInput("dayfour.txt", None)

    val rolls = findRolls(inputLines)

    print(s"number that can be found ${rolls.count(_ < 4)}")

  }

}
