class Student(name: String, age: Int) {

  def this(name: String) = {
    this(name, 18)
  }

  def printDetails() = {
    println("Student Details - ")
    println("Name - " + name)
    println("Age - " + age)
    println("=======================================")
  }
}

class A {
  def this(contact:BigInt) {
    this()
    println("========================contact details =======================")
    println(contact)
    println("===============================")
  }

}


object ConstructorTry extends App {
  val s1 = new Student("Rasik", 28)
  s1.printDetails()
  val s2 =  new Student("ABCD")
  s2.printDetails()

  val a = new A(123456789)
}
