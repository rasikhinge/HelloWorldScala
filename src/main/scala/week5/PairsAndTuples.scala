package week5

class MergeSort {
  def mSort[T](xs: List[T])(implicit ord: Ordering[T]): List[T] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {
      def merge(subList1: List[T], subList2: List[T]): List[T] = {
        (subList1, subList2) match {
          case (Nil, ys) => ys
          case (xs, Nil) => xs
          case (x :: xs1, y :: ys1) => {
            if (ord.lt(y, x)) y :: merge(ys1, subList1)
            else
              x :: merge(subList2, xs1)
          }
        }

      }

      val (fst, snd) = xs splitAt (n)
      merge(mSort(fst), mSort(snd))

    }
  }

}


object PairsAndTuples {

  def main(args: Array[String]): Unit = {
    val sorting = new MergeSort()
    val sorted = sorting.mSort(List(1, 2, -3, 5, 4))
    println(sorted)

    val fruits = List("apple", "orange", "pineapple", "banana", "watermelon")
    var sortedFruits = sorting.mSort(fruits)
    println(sortedFruits)
  }

}
