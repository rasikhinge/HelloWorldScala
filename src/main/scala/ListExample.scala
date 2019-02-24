object ListExample extends App {

  val list = List(1,223,4,5,6,7,8,9,9)
  listOp(1,list)



  def listOp(element:Int , list:List[Int]): Unit ={

    println("head = "+list.head)

    println("tail = "+list.tail)

    val e1::e2::rest =list
    println("e1 = "+e1)
    println("e2 = "+e2)
    println("rest = "+rest)

  }
}
