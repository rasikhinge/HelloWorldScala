package week4

import java.util.NoSuchElementException


trait IntList {
  def isEmpty: Boolean

  def head: Int

  def tail: IntList
}



class Cons(val head: Int, val tail: IntList) extends IntList {
  override def isEmpty: Boolean = false

  def singleton(value: Int) = new Cons(value, new Nil)

  override def toString() = head + " " + tail

  def nth(n: Int, list: IntList): Int = {

    def calcNth(index: Int, count: Int, list: IntList): Int = {
      if (index < 0 || list.isEmpty) throw new IndexOutOfBoundsException

      else if (count == index)
        list.head
      else
        calcNth(index, count + 1, list.tail)
    }

    calcNth(n, 0, list)
    /*
        def calcNth(index: Int, list: IntList): Int = {
          if (list.isEmpty) throw new IndexOutOfBoundsException
          else if (index == 0)
            list.head
          else
            calcNth(index - 1, list.tail)
        }

        calcNth(n, list)*/
  }

}

class Nil extends IntList {
  override def isEmpty: Boolean = true

  override def head: Nothing = throw new NoSuchElementException("Nil.head")

  override def tail: Nothing = throw new NoSuchElementException("Nil.head")

  override def toString: String = "Nil"
}


object Polymorphism_IntList extends App {

  val cons = new Cons(1, new Nil)
  private val singletonCons: Cons = cons.singleton(5)
  println(singletonCons)

  private val tail = new Cons(3, new Cons(2, new Cons(1, new Nil)))
  val consList = new Cons(4, tail)
  println(consList)
  println(consList.head)
  println(consList.tail)
  println("nth 2 - " + cons.nth(2, consList))
//  println("nth 6 - " + cons.nth(6, consList))
  println("nth -1 - " + cons.nth(-1, consList))
}
