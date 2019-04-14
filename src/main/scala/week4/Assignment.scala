package week4

abstract class CodeTree

case class Fork(left: CodeTree, right: CodeTree, chars: List[Char], weight: Int) extends CodeTree

case class Leaf(char: Char, weight: Int) extends CodeTree

class HuffmanList {
  def weight(tree: CodeTree): Int = {
    tree match {
      case Fork(left, right, chars, wt) => weight(left) + weight(right) + wt
      case Leaf(char, wt) => wt
    }
  }


}

object Assignment extends App {
}
