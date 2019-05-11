package week6

class PhoneNumberToStringConverter {

  val mnem = Map('2' -> "ABC", '3' -> "DEF", '4' -> "GHI", '5' -> "JKL"
    , '6' -> "MNO", '7' -> "PQRS", '8' -> "TUV", '9' -> "WXYZ")

  //reverse of above Map, mapping for each char -> digit
  val charCode: Map[Char, Char] =
    for ((digit, str) <- mnem; charr <- str) yield (charr -> digit)

  // "JAVA" = 5282
  def wordCode(word: String): String = {
    /*    word.map(cr => {
          charCode.get(cr) match {
            case None => ""
            case Some(x) => x
          }
        }).toList.toString()*/
    word.toUpperCase().map(cr => charCode(cr))
  }

  def wordsGroupByNumCode(string: String): Map[String, String] = {
    string groupBy (cr => wordCode(cr.toString())) withDefaultValue ("")
  }

  // 5282 = List("JAVA","KAVA","LAVA","JBVB",...)
  def digitsToWords(digits: String, wordsGroupByNum: Map[String, String]): Seq[List[Any]] = {
    if (digits.isEmpty) Seq(List())
    else {
      val seq = for {
        i <- 1 to digits.length
        crStr <- wordsGroupByNum(digits take i)
        restCr <- digitsToWords(digits drop i, wordsGroupByNum)
      } yield {
        println(crStr)
        println(restCr)
        crStr :: restCr
      }
      seq
    }

  }
}

object PracExample {
  def main(args: Array[String]): Unit = {
    val p = new PhoneNumberToStringConverter
    //println(p.charCode)
    val result = p.wordCode("JAVA")
    //println(result)
    //Only Upper case is mapped
    val result1 = p.wordCode("Java")
    // println(result1)

    //  val result2 = p.digitsToWords("5282")

    val result3 = p.wordsGroupByNumCode("ABCDEFGHIJKLMNOPQRSTUVWXYZ")
    println(result3)
    val result4 = p.digitsToWords("24", result3)
    rintln(result4)
  }
}
