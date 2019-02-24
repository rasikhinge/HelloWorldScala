abstract class AbsIterator {
  type T

  def hasNext: Boolean

  def next: T
}

trait RichIterator extends AbsIterator {
  def foreach(f: T => Unit) = {
    while (hasNext) {
      f(next)
    }
  }
}


class StringIterator(str: String) extends AbsIterator {
  type T = Char
  private var i = 0;

  override def hasNext = {
    i < str.length
  }

  override def next = {
    val ch = str.charAt(i)
    i += 1
    ch
  }

}

object MixinPractice extends App {
class Itr extends StringIterator("Rasik") with RichIterator
  val itr = new Itr
  itr.foreach(print)
}
