package week3


trait Planer {
  def height: Int

  def width: Int

  def surface = height * width


}

class Traits {

  def error(msg: String) = throw new Error(msg)
}

object Traits extends App {
  val t = new Traits
  private val value: Nothing = t.error("error")
//  val y: Int = null //Not allowed
  val x: String= null
}
