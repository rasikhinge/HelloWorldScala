package week1

class Recursion {

  def gcd(a: Int, b: Int): Int = {
    if (b == 0) a else gcd(b, a % b)
  }

  def sum(f:Int => Int)(a: Int, b: Int) = {
    def sumIt(a: Int, previousSum: Int): Int = {
      if (a > b) previousSum
      else {
        sumIt(a + 1, f(a) + previousSum)
      }
    }
    sumIt(a,0)
  }

}

object RecursiveCall extends App {
  val r = new Recursion;
  println(r.gcd(14, 21))
  println(r.sum(x => x)(1,10))
  println(r.sum(x => x*x)(1,5))
}
