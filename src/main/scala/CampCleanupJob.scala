object CampCleanupJob extends App {
  val input_data = CampCleanup.openFile("/Users/curnowl/Developer/AdventOfCode2022/day_4_CampCleanup/src/main/cleanup_data.txt")
  println(CampCleanup.countMatches(input_data))
}
