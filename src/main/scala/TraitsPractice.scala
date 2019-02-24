trait Similarity {
  def isSimilar(x: Any): Boolean

  def isNotSimilar(x: Any): Boolean = {
    !isSimilar(x)
  }
}


class Point(val xc: Int, val yc: Int) extends Similarity {

  override def isSimilar(obj: Any): Boolean = {
    obj.isInstanceOf[Point] && obj.asInstanceOf[Point].xc == xc
  }

}

object TraitsPractice extends App {

  val p = new Point(1, 2)
  val q = new Point(1, 2)
  val r = new Point(3, 4)
  println("p is similar to q " + p.isSimilar(q))
  println("q is similar to r " + q.isSimilar(r))
  println("q is not similar to r " + q.isNotSimilar(r))
  println("p is insatnce of Similarity "+p.isInstanceOf[Similarity])
  println("p is instance of Point "+p.isInstanceOf[Point])
}
