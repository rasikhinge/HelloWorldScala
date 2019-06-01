package week6

import scala.io.{BufferedSource, Source}
import scala.util.{Failure, Success, Try}

object FileReader extends App {

  val lines = readFile() match {
    case Success(x) => Some(x.getLines().toList)
    case Failure(exception) => exception + "Could Not Open File"
  }

  def readFile(): Try[BufferedSource] = {
    Try({
      val stream = getClass.getResourceAsStream("/name.txt")
      Source.fromInputStream(stream)
    })
  }

  val contents = lines match {
    case Some(x) => x
    case None => "No content"
  }

  println(contents)


}
