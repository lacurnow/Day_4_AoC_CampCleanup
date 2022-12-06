import scala.io.Source

object CampCleanup {
  def openFile(filename: String): String = {
    val dataSource = Source.fromFile(filename)
    val lines: String = dataSource.mkString
    dataSource.close
    lines
  }

  def countMatches(input_data: String): Int = {
    val pairOfElves = input_data.split("\n")
    pairOfElves.map{
      elfPair =>
        val rangePairs: Array[String] = elfPair.split(",")
        if(compareRanges(rangePairs)) {
          1
        } else {
          0
        }
      }.sum
    }

  def compareRanges(elfPair: Array[String]): Boolean = {
    val rangeElfOne = getRange(elfPair(0))
    val rangeElfTwo = getRange(elfPair(1))
    val lengthOne = rangeElfOne.length
    val lengthTwo = rangeElfTwo.length
    val commonSections = (rangeElfOne intersect rangeElfTwo).length
    if (lengthOne > lengthTwo) {
      commonSections == lengthTwo
    } else {
      commonSections == lengthOne
    }
  }

  def getRange(elf: String): List[Int] = {
    val range: Array[String] = elf.split("-")
    val begin = range(0).toInt
    val end = range(1).toInt
    (begin to end).toList
  }
}
