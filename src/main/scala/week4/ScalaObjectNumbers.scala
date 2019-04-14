package week4

abstract class Nat {
  def isZero:Boolean
  def predecessor : Nat
  def successor : Nat
  def +(that:Nat): Nat
  def -(that:Nat) : Nat

}

//object Zero extends Nat {
//  override def isZero: Boolean = true
//
//    override def predecessor: Nat = throw Error
//}

object ScalaObjectNumbers {
var o:Int = 10
var o1:Boolean = false


}
