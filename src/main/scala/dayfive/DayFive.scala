package dayfive

import helpers.AdventOfCodeSolver

case class ValidIngredientRange(input: String) {
  val start: Long = input.substring(0, input.indexOf("-")).toLong
  val end: Long = input.substring(input.indexOf("-") + 1).toLong

  def inRange(ingredientId: Long): Boolean = start <= ingredientId && ingredientId <= end
}

object DayFive extends AdventOfCodeSolver {

  def splitRangesAndIds(input: List[String]): (List[ValidIngredientRange], List[String]) = {
    val validRanges: (List[String], List[String]) = input.splitAt(input.indexOf(""))
    (validRanges._1.map(vr => ValidIngredientRange(vr)), validRanges._2.tail)
  }

  def fitsAnyValidRange(id: Long, ranges: List[ValidIngredientRange]): Boolean = {
    ranges.exists(range =>
      range.inRange(id)
    )
  }

  def main(args: Array[String]): Unit = {

    val input: List[String] = readInput("dayfive.txt", None)

    val (ranges, ids) = splitRangesAndIds(input)

    val numValidIds = ids.filter(id => fitsAnyValidRange(id.toLong, ranges))

    print(s"the number of valid ids is: ${numValidIds.length}")
  }
}
