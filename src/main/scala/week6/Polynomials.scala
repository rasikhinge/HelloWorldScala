package week6

object Polynomials {

  class Poly(val terms0: Map[Int, Double]) {

    // * indicates repeated parameter, o or more occurances
    def this(expo_coef_pairs: (Int, Double)*) = this(expo_coef_pairs.toMap)

    val terms = terms0 withDefaultValue (0.0)

    def +(other: Poly) = new Poly(terms ++ other.terms.map(ot => adjust(ot)))

    def adjust(otherTerm: (Int, Double)): (Int, Double) = {
      val (expo, coef) = otherTerm
      // Need to map expo of 2st map into 1nd map and
      // then check if expo of 2nd map is present in 1st map
      //      terms get (expo) match {
      //        case None => expo -> coef
      //        case Some(coef1) => expo -> (coef + coef1)
      //      }

      //Instead We can use withDefaultValue
      //If expo of 2nd map is not present in 1st map give default value instead of exception or None
      expo -> (coef + terms(expo))
    }

    def plus(other: Poly) = {
      val functionToTuple = other.terms.foldLeft(terms)((terms, t2) => addTerm(terms, t2))

      new Poly(functionToTuple)
    }

    def addTerm(terms: Map[Int, Double], term: (Int, Double)): Map[Int, Double] = {
      val (e, c) = term
      println("================================")
      println(terms.toString())
      println(e + " " + c)
      println("================================")

      val (e1, c1) = terms get e match {
        case None => e -> c
        case Some(t) => e -> (c + t)
      }
      terms + (e -> (c + terms(e)))
      //      terms ++ Map(e1 -> c1)

    }

    override def toString(): String = {
      (for ((exponent, coefficient) <- terms.toList.sorted.reverse)
        yield coefficient + "X^" + exponent).mkString(" + ")
    }
  }

  def main(args: Array[String]): Unit = {

    // x^2 - 2x +3
    val p1 = new Poly(0 -> 3.0, 1 -> -2.0, 2 -> 1)
    // 2x^3 + 4x +5
    val p2 = new Poly(0 -> 5.0, 1 -> 4.0, 3 -> 2.0)
    println(p1.toString())
    println(p2.toString())

    val result = p1 + p2
    val result1 = p1 plus p2
    println(result.toString())
    println(result1.toString())
  }
}
