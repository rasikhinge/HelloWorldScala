package week6

class Queens {
  def queens(n: Int): Set[List[Int]] = {
    def placeQueens(k: Int): Set[List[Int]] = {
      if (k == 0) Set(List())
      else
        for {
          queens <- placeQueens(k - 1)
          col <- (0 until n).toList
          if isSafe(queens, col)
        } yield col :: queens
    }

    def isSafe(queens: List[Int], col: Int): Boolean = {
      val row = queens.length
      println("queens =  " + queens)
      println("row = " + row + ", col = " + col)
      val queensWithRow = ((row - 1) to 0 by -1) zip queens
      queensWithRow.forall {
        case (r, c) => {
          println("r = " + r + ", c = " + c)
          col != c && math.abs(col - c) != row - r
        }
      }

    }

    placeQueens(n)
  }

}


object NQueens {
  def main(args: Array[String]): Unit = {
    val q = new Queens
    val result: Set[List[Int]] = q.queens(4)
    result.foreach(list => {
      print("List(")
      list.foreach(l => print(l + ", "))
      print(")\n")
    })
  }
}
