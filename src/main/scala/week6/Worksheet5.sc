import scala.util.{Failure, Success, Try}

val optInt: Option[Int] = Option(1)


def divide(): Try[Int] = {

  Try(2 / 0)
}


def divide1(): Option[Int] = {

  Some(2 / 0)
}
//Try,Success,Failure for exception handling
divide() match {
  case Success(z) => z
  case Failure(e) => "Could Not divide by 0"
}

//Option,Some,None for Null handling
divide1() match {
  case Some(z) => z
  case None => 0
}