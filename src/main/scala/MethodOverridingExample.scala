class Bank {
  def calculateRateOfInterest(duration: String): Unit = {
    println("Rate of Interest by default is - " + 8.5 + "%")
  }
}

class ICICIBank extends Bank {
  override def calculateRateOfInterest(duration: String): Unit = {
    println("Rate of Interest for duration $s is 9.5%", duration)
  }
}


class Vehicle {
  val speed: Int = 100
}

class Bike extends Vehicle {

  override val speed: Int = 60

  def printSpeed(vehicle: Vehicle): Unit = {
    println("speed = " + vehicle.speed)
  }

}


abstract class Abstract(a: Int) {

  var b: Int = 10

  def showData()

  def display() = {
    println("a=   " + a + "  b= " + b)
  }
}


class Concrete(a: Int) extends Abstract(a) {

  b = 50
  def showData(): Unit = {
    println("Concrete = a = " + a + " b = " + b)

  }
}

object MethodOverridingExample extends App {

  var bank = new Bank
  bank.calculateRateOfInterest("5years")
  bank = new ICICIBank
  bank.calculateRateOfInterest("5 years")

  val bike = new Bike
  bike.printSpeed(bike)


  val a = new Concrete(40)
  a.display()
  a.showData()


}
