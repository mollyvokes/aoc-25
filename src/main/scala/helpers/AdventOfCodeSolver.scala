package helpers

trait AdventOfCodeSolver {

  def readInput(fileName: String): List[String] = {
    import scala.io.Source
    val source = Source.fromFile("src/main/resources/inputs/" + fileName)
    val lines = source.getLines().toList
    source.close()
    lines
  }

}
