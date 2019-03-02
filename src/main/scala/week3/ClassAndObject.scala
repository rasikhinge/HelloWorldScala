package week3


abstract class IntSet {
  def incl(x: Int): IntSet

  def contains(x: Int): Boolean


  def union(other: IntSet): IntSet
}

class Empty extends IntSet {
  def contains(x: Int): Boolean = false

  def incl(x: Int): IntSet = new NonEmpty(x, new Empty, new Empty())

  override def toString: String = "."

  def union(other: IntSet): IntSet = other
}

class NonEmpty(value: Int, left: IntSet, right: IntSet) extends IntSet {

  def contains(x: Int): Boolean = {
    if (x < value) left.contains(x)
    else if (x > value) right.contains(x)
    else true
  }

  def incl(x: Int): IntSet = {
    println(value)
    if (x < value) new NonEmpty(value, left.incl(x), right)
    else if (x > value) new NonEmpty(value, left, right.incl(x))
    else this
  }

  override def toString = "{" + left + " " + value + " " + right + " }"

  def union(other: IntSet): IntSet = {
    ((left union right) union other) incl value
  }
}

class ClassAndObject {

}

object ClassAndObject extends App {
  val t1 = new NonEmpty(3, new Empty, new Empty)
  val t2 = t1 incl (4)
  val t3 = new NonEmpty(5, new Empty, new Empty)

 /* println(t2)
  println(t3)*/

  private val unionSet: IntSet = t3 union t2
  println(unionSet)


}
