package week3

import java.util.function.Predicate

class Sets {

  type Set = Int => Boolean

  def contains(s: Set, element: Int) = s(element)

  def singltonSet(ele: Int): Set = (x) => x == ele

  def union(set1: Set, set2: Set): Set = (ele) => contains(set1, ele) || contains(set2, ele)

  def intersection(set1: Set, set2: Set): Set = (ele) => set1(ele) && set2(ele)

  def diff(set1: Set, set2: Set): Set = ele => contains(set1, ele) && !contains(set2, ele)

  def filter(set: Set, predicate: Predicate[Int]): Set = ele => contains(set, ele) && predicate.test(ele)

  def map(set: Set, f: Int => AnyVal): Set = (ele) => forall(set, (x) => ele == f(x))

  def buildSet1000: Set = {
    val firstSet: Set = singltonSet(-1000)
    (-1000 to 1000).foldLeft(firstSet)((result, next) => union(result, singltonSet(next)))
  }

  def forall(s: Set, p: Int => Boolean) = {
    def inforall(ele: Int, p: Int => Boolean): Boolean = {
      if (ele < -1000 || ele > 1000) {
        true
      } else if (contains(s, ele) && !p(ele)) {
        false
      } else {
        inforall(ele + 1, p)
      }
    }

    inforall(-1000, p)
  }
}


object Sets extends App {
  val set = new Sets

  val re = set.singltonSet(1)
  private val result: Boolean = set.contains(x => x < 0, 5)
  println(result)

  val union2and4 = set.union(set.singltonSet(2), set.singltonSet(4))
  val union3and4 = set.union(set.singltonSet(3), set.singltonSet(4))
  val intersection4andUnion2and4 = set.intersection(set.singltonSet(4), union2and4)
  val diff_reandUnion2and4 = set.diff(re, union2and4)
  val evenPredicate: Predicate[Int] = ele => ele % 2 == 0
  val filter = set.filter(union3and4, evenPredicate)
  val build1000 = set.buildSet1000

  println("result = " + set.contains(re, 1))
  println("union result = " + set.contains(union2and4, 3))
  println("intersection result = " + set.contains(intersection4andUnion2and4, 4))
  println("diff result = " + set.contains(diff_reandUnion2and4, 1))
  println("predicate result = " + filter(3))

  val singleton2 = set.singltonSet(2)
  private val bool: Boolean = set.forall(singleton2, x => x % 2 == 0)

  println("forall = " + bool)

  private val transformFunction = set.map(singleton2, x => x * 2)

  println("transform to 4 " + transformFunction(4))
}
