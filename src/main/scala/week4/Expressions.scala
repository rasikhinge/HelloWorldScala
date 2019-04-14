//package week4
//
//trait Expr {
//  def isNumber: Boolean
//
//  def isSum: Boolean
//
//  def numValue: Int
//
//  def leftOpt: Expr
//
//  def rightOpt: Expr
//
//  def eval(e: Expr): Int = {
//    if (e.isNumber) e.numValue
//    else if (e.isSum) eval(e.leftOpt) + eval(e.rightOpt)
//    else throw new Error("error")
//  }
//
//}
//
//class Number(n: Int) extends Expr {
//
//  override def isNumber: Boolean = true
//
//  def isSum: Boolean = false
//
//  def numValue: Int = n
//
//  def leftOpt: Expr = throw new Error("LeftOpt Error")
//
//  def rightOpt: Expr = throw new Error("rightOpt Error")
//
//
//}
//
//class Sum(e1: Expr, e2, Expr) extends Expr {
//  def isNumber: Boolean = false
//
//  def isSum: Boolean = true
//
//  def numValue: Int = throw new Error("Error")
//
//  def leftOpt: Expr = e1
//
//  def rightOpt: Expr = e2
//}
//
//d
//
//class Expressions {
//
//}
