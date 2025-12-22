package dayfour

import helpers.AdventOfCodeSolver

import scala.annotation.tailrec

object DayFour extends AdventOfCodeSolver {

  def countSurroundingRolls(sectionToCheck: String): Int = {
    sectionToCheck.count(_.equals('@')) - 1
  }

  @tailrec
  def findRolls(diagramLength: Int, rowLength: Int, diagram: List[String], currCount: Int): Int = {
    def checkSurroundings(i: Int, j: Int): Int = {
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
    }

    var changed = 0

    val newDiagram = (0 until diagramLength).map(i => {
      (0 until rowLength).foldLeft("")((s, j) => {
        if (diagram(i)(j) == '@') {
          if (checkSurroundings(i,j) < 4) {
            changed = changed + 1
            s + "."
          } else s + "@"
        } else s + "."
      })
    }).toList

    if (changed == 0) currCount else findRolls(diagramLength, rowLength, newDiagram, currCount + changed)
  }

  def main(args: Array[String]): Unit = {

    val inputLines = readInput("dayfour.txt", None)

    val diagramLength = inputLines.length
    val rowLength = inputLines.head.length

    val rollsCount = findRolls(diagramLength, rowLength, inputLines, 0)

    print(s"number that can be found ${rollsCount}")

  }

}
