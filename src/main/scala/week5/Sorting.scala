package week5

class SortPrograms {

  def insertionSort(xs: List[Int]): List[Int] = {
    xs match {
      case List() => List()
      case x1 :: xs1 => insert(x1, insertionSort(xs1))
    }
  }

  def insert(n: Int, xs: List[Int]): List[Int] = {
    xs match {
      case List() => n :: xs
      case x1 :: xs1 => if (x1 > n) n :: xs else x1 :: insert(n, xs1)
    }
  }

  def bubbleSort(xs: List[Int]): List[Int] = {
    xs match {
      case List() => List()
      case List(x1) => List(x1)
      case x1 :: x2 :: xs1 => if (x1 > x2) x2 :: x1 :: bubbleSort(xs1) else x1 :: x2 :: bubbleSort(xs1)
    }
  }
}


object Sorting {

  def main(args: Array[String]): Unit = {
    val unsorted = List(1, 3, 2, 5, 4, 6, 7, 8)
    val sorter = new SortPrograms
    val sorted = sorter.insertionSort(unsorted)
    println(sorted)
  }
}
