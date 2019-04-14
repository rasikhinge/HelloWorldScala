package week4


trait Exprn {

  def eval(e: Exprn): Int =
    e match {
      case Number1(n) => n
      case Sum(e1, e2) => eval(e1) + eval(e2)
    }

}

case class Number1(n: Int) extends Exprn

case class Sum(e1: Exprn, e2: Exprn) extends Exprn

object PatternMatching extends App {
  val e: Exprn = Number1(2)
  val result: Int = e.eval(Sum(Number1(1), Number1(3)))
  println("result" + result)
}
