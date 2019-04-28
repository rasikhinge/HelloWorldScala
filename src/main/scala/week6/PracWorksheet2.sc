// n = 7 where i + j = prime and j<i<n
def isPrime(n: Int): Boolean = {
  (2 until (n)) forall (num => n % num != 0)
}


val list1 = (1 to 7) flatMap (j => {
  val i = j + 1
  val list = (i to 7) map (i1 => if (isPrime(i1 + j)) (i1, j) else Nil)
  (list).filter(v => v != Nil)
})

val forList = for {
  i <- 1 to 7
  j <- 1 to i
  if isPrime(i + j)
} yield (i, j)

println(list1)
println(forList)

def scalarProductWithFor(xs: Vector[Double], ys: Vector[Double]) = {
  val p = for {
    (x, y) <- (xs zip ys)
  } yield (x * y)
  p.sum
}

val xs = Vector(1.0, 2.0, 3.0)
val ys = Vector(4.0, 5.0, 6.0)
val scalarP = scalarProductWithFor(xs, ys)
println(scalarP)


val set = (1 to 6).toSet
set.map(_ + 2)
set map (_ / 2)


val i1 = List().length
val zipI1 = (i1 - 1 to 0 by -1) zip List()

zipI1 map (z1 => z1 match {
  case (r, c) => println(r, c)
})