package week5


class ListFunctions {

  def last[T](xs: List[T]): T = {
    xs match {
      case List() => throw new Error("empty")
      case List(x) => x
      case y :: ys => println(ys); last(ys);
    }
  }

  def init[T](xs: List[T]): List[T] = {
    xs match {
      case List() => throw new Error("empty")
      case List(x) => println(x); List()
      case y :: ys => y :: init(ys)
    }
  }

  def concat[T](xs: List[T], ys: List[T]): List[T] = {
    xs match {
      case List() => ys
      case z :: zs => z :: concat(zs, ys)
    }
  }

  def reverse[T](xs: List[T]): List[T] = {
    xs match {
      case List() => xs
      case List(x) => List(x)
      case y :: ys => reverse(ys) ++ List(y)
    }
  }

  def removeAt[T](index: Int, xs: List[T]): List[T] = {
    (xs take index) ::: (xs drop index + 1)
  }

  def insertionSort(xs: List[Int]): List[Int] = {
    xs match {
      case List() => List()
      case y :: ys => insert(y, insertionSort(ys))
    }
  }

  def insert(x: Int, xs: List[Int]): List[Int] = {
    xs match {
      case List() => x :: xs
      case y :: ys => if (x > y) y :: insert(x, ys) else x :: xs
    }
  }

}

object ListOperations {

  def main(args: Array[String]): Unit = {
    val intList: List[Int] = List(1, 2, 2, 3, 5, 6, 7, 8)
    val intList1: List[Int] = List(11, 22, 33, 44, 55, 66, 77, 88)
    val lstFunc = new ListFunctions()
    val result: Int = lstFunc.last(intList)
    val result1: List[Int] = lstFunc.init(intList)
    val result2: List[Int] = lstFunc.concat(intList, intList1)
    val result3: List[Int] = lstFunc.reverse(intList)
    val result4: List[Int] = lstFunc.removeAt(3, intList)
    val result5: List[Int] = lstFunc.insertionSort(result3)
    println(result)
    println(result1)
    println(result2)
    println(result3)
    println(result4)
    println(result5)


  }

}
