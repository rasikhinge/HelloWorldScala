package week6

case class Employee(name: String, age: Int)

class A {
  implicit val w = 30
  def showDetails(implicit emp: Employee) = {
    println(emp.name)
  }


  def sumBy(implicit i: Int): Unit = {
    i + 10
  }
}

object ImplicitExample {

  implicit val q = 20

  def main(args: Array[String]): Unit = {
    val emp = Employee("name", 20)
    val a = new A()
    a.showDetails(emp)
    a.showDetails("Rasik")
    a.sumBy
  }

  implicit def toEmployee(name: String): Employee = {
    Employee(name, 10)
  }
}
