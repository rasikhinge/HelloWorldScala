package week5

class MergeSort {
  def mSort(xs: List[Int]): List[Int] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {
      def merge(subList1: List[Int], subList2: List[Int]): List[Int] = {
        (subList1,subList2) match {
          case (Nil,ys) => ys
          case (xs,Nil) => xs
          case (x::xs1,y::ys1) => {
            if(x > y) y :: merge(ys1,subList1)
            else
              x::merge(subList2,xs1)
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
    val sorted = sorting.mSort(List(1, 2, 3, 5, 4))
    println(sorted)
  }

}
