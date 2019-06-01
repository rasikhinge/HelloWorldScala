val optInt: Option[Int] = Some(1)
val optInt1: Option[Int] = Option(1)

val result = optInt match {
  case Some(x) => x
  case None => 0
}

val optInt2 = Option(None)
val result1 = optInt2 match {
  case Some(x) => x
  case None => 0
}
//
val opt3 = None
//opt3.get

val list = List(Some(1), Some(2), None, Some(4), Some(5), Some(6), None, None)
list.filter(e => e.isDefined).map(e1 => e1.get)
list.flatten
list.flatMap(e => if (e.isDefined) Some(e.get + 2) else None)
list.map(e => if (e.isDefined) Some(e.get + 2) else None)
list.map(e => e.fold(0)(e1 => e1 + 2))

optInt1.fold(0)(e => e * 2)

optInt2.fold(0)(e => 5)
opt3.fold(10)(e => 20)
optInt1.flatMap(e => Some(e + 20))
optInt1.map(e => Some(e + 20))


def getNumber(): Option[Int] = {
  None
  Option(10)
}

getNumber().fold(20)(e => e)

getNumber() match {
  case Some(x) => x + 10
  case None => 100
}