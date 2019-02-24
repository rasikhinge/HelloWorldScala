
def isGoodEnough(guess:Double, x:Double) : Boolean =
  math.abs(guess * guess - x) < 0.001

def improve(guess: Double, x: Double) =
  (guess + x /guess)/ 2

def sqrtIter(guess:Double, x:Double):Double =
  if(isGoodEnough(guess, x)) guess
  else sqrtIter(improve(guess, x), x)


def sqrt(x:Double) = sqrtIter(1.0, x)

sqrt(2)
sqrt(4)
sqrt(9)

