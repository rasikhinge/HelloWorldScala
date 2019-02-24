package week3

class Rational(x: Int, y: Int) {
  def numer = x

  def denom = y

  def  +(r1: Rational): Rational = {
    val rational = new Rational(
      numer * r1.denom + r1.numer * denom,
      denom * r1.denom
    )
    rational
  }

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  def - (r: Rational) = {
    /*new Rational(
      numer * r.denom - r.numer * denom,
      r.denom * denom
    )*/
    this + -r
  }

  def unary_- : Rational = new Rational(-numer, denom)

  def makeString(r: Rational) = {
    r.numer + "/" + r.denom
  }

  override def toString: String = numer + "/" + denom
}


object FunctionsAndData extends App {

  val rational = new Rational(1, 2)
  println(rational.numer)
  println(rational.denom)

  println(rational.makeString(rational + new Rational(2, 3)))

  val x = new Rational(1, 3)
  val y = new Rational(5, 7)
  val z = new Rational(3, 2)

  private val rational1: Rational = x - y  - z
  println("Result - " + rational1)
  private val rational2: Rational = y + y
  println("Result - " + rational2)

}
