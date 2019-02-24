package week1

class RecursionFactorial {

  def factorial(n:Int):Int = {
    if(n == 0)
      1
    else
      n * factorial(n -1)
  }

  def tailFactorial(previousResult:BigInt,n:BigInt) :BigInt= {
    if(n == 0)
      previousResult
    else
      tailFactorial( n * previousResult,n-1)
  }

  def fact(n:Int): Unit ={
   print(tailFactorial(1,n))
  }

}


object RecursionFactorial extends App{
  val r1 = new RecursionFactorial
 // println(r1.factorial(500))
  r1.fact(500)
}