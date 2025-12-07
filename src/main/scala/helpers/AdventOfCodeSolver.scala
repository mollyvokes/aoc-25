package helpers

trait AdventOfCodeSolver {

  def readInput(fileName: String, delimiter: Option[String]): List[String] = {
    import scala.io.Source
    val source = Source.fromFile("src/main/resources/inputs/" + fileName)
    val lines = source.getLines().toList
    source.close()

    delimiter match {
      case Some(d) => lines.head.split(d).toList
      case _ => lines
    }
  }

}
