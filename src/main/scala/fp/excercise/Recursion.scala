package fp.excercise

class TailRecursion {

  def febo(n: Int): Int = {
    var n1: Int = 0;
    var n2: Int = 1;
    var result: Int = 0
    var i = 2
    print(" " + n1 + " " + n2)
    while (i < n) {
      result = n1 + n2;
      print(" " + result)
      n1 = n2
      n2 = result
      i = i + 1
    }
    result
  }

  def feboRec(n: Int): Int = {
    def go(index: Int, result: Int, n1: Int, n2: Int): Int = {
      if (index > n) result
      else
        go(index + 1, n1 + n2, n2, n1 + n2)
    }

    go(2, 0, 0, 1)
  }

  def findFirst(ds: Array[Double], key: Double): Int = {
    def loop(index: Int): Int = {
      if (index > ds.length) -1
      else if (ds(index) == key) index
      else
        loop(index + 1)
    }

    loop(0)
  }
}

object Recursion extends App {
  val t = new TailRecursion()
  private val i: Int = t.feboRec(6)
  println(i)
  val ds: Array[Double] = Array(1.0, 2.0, 3.0, 4.0, 5.0, 6.0);
  val result: Int = t.findFirst(ds, 3.0)
  println("find First = " + result)
}
