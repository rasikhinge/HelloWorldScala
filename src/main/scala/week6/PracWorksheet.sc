val combinations1 = (1 to 10).map(x => (11 to 20).map(y => List(x, y)))
println(combinations1)
val combinations2 = (1 to 10).flatMap(x => (11 to 20).map(y => List(x, y)))
println(combinations2)

//scalar product , sum of product of Xi and Yi elements
def scalarProduct(xs: Vector[Double], ys: Vector[Double]): Double = {
  val pairs: Vector[(Double, Double)] = xs zip ys
  val products = pairs map {
    case (x1, y1) => x1 * y1
  }

  products.sum
}

val xs = Vector(1.0, 2.0, 3.0)
val ys = Vector(4.0, 5.0, 6.0)
val scalarP = scalarProduct(xs, ys)
println(scalarP)


def isPrime(n: Int): Boolean = {
  !((2 until n) exists (num => n % num == 0))
}
//def isPrime(n:Int):Boolean = {
//  (2 to n) forall (d => n % d != 0)
//}

val isP = isPrime(5)
val isP1 = isPrime(6)
val isP2 = isPrime(7)