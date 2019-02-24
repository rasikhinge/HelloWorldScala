package week2

class FunctionCurrying {

  def product(f: Int => Int)(a: Int, b: Int) = {
    def productIt(a: Int, previousResult: BigInt): BigInt = {
      if (a > b) previousResult
      else {
        productIt(a + 1, f(a) * previousResult)
      }
    }

    productIt(a, 1)
  }

  def sum(f: Int => Int)(a: Int, b: Int) = {
    def sumIt(a: Int, previousSum: Int): BigInt = {
      if (a > b) previousSum
      else {
        sumIt(a + 1, f(a) + previousSum)
      }
    }

    sumIt(a, 0)
  }

  def operation(f: Int => Int, op: (Int, Int) => Int, startValue: Int)(a: Int, b: Int) = {
    def calculate(a1: Int, previousResult: Int): Int = {
      if (a1 > b) previousResult
      else {
        calculate(a1 + 1, op(f(a1), previousResult))
      }
    }

    calculate(a, startValue)
  }

}

object FunctionCurrying extends App {
  val functionCurrying = new FunctionCurrying
  //  println(functionCurrying.product(x => x)(1, 5))
  //  println(functionCurrying.sum(x => x)(1, 10))
  println(functionCurrying.operation(x => x, (x, y) => x * y, 1)(1, 5))
  println(functionCurrying.operation(x => x, (x, y) => x + y, 0)(1, 10))


}