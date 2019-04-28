package week5


abstract class MyList[T] {

}


class ListHigherOrderFunction {

  def scaleList(xs: List[Int], factor: Int): List[Int] = {
    xs match {
      case List() => List()
      case x :: xs1 => (x * factor) :: scaleList(xs1, factor)
    }
  }

  def squareList(xs: List[Double]): List[Double] = {
    xs match {
      case List() => List()
      case x :: xs1 => (x * x) :: squareList(xs1)
    }
  }

  def posElem(xs: List[Int]): List[Int] = {
    xs match {
      case Nil => Nil
      case y :: ys => if (y > 0) y :: posElem(ys) else posElem(ys)
    }
  }

  //List("a","a","a","a","b","b","b","c","c","c","c","a")

  def pack[T](xs: List[T]): List[List[T]] = {
    xs match {
      case Nil => Nil
      case y :: ys => {
        val first = y :: ys.takeWhile(ys1 => ys1 == y)
        val rest = ys.dropWhile(ys1 => ys1 == y)
        first :: pack(rest)
      }
    }
  }

  def encode[T](xs: List[T]): List[(T, Int)] = {
    val result = pack(xs)
    result.map(list => (list.head, list.length))
  }


}


object HigherOrderListFunctions {

  def main(args: Array[String]): Unit = {
    val exe = new ListHigherOrderFunction()
    val nums = List(1, 2, 3, 4, 5, 6, 7, -9)
    val doubles = List(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, -9.0)
    val ints = exe.scaleList(nums, 3)
    println("result = " + ints)
    val squares = exe.squareList(doubles)
    println("square = " + squares)
    val positiveE = exe.posElem(nums)
    println(positiveE)
    val input = List("a", "a", "a", "a", "b", "b", "b", "c", "c", "c", "c", "a")
    val output = exe.pack(input)
    println(output)
    val encoded = exe.encode(input)
    println(encoded)
  }

}
