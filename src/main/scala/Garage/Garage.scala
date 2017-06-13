package Garage

import scala.collection.mutable.ListBuffer
import scala.util.Random

/**
  * Created by Profile on 12/06/2017.
  */
object Garage {
  var vehicles: ListBuffer[Vehicle] = new ListBuffer[Vehicle]
  var employees: ListBuffer[Person] = new ListBuffer[Person]
  var allparts: ListBuffer[Part] = new ListBuffer[Part]
  var computerGuess = scala.util.Random

  def main(args: Array[String]): Unit = {
    instantiateEmployees()
    instantiateParts()
    instantiateCars()


  }

  //Add, Remove By Id and Remove By Type
  def addVehicle(vehicle: Vehicle) = vehicles += vehicle

  def removeVehicleById(id: Int) = vehicles.map(veh => if (veh.id == id) vehicles.remove(vehicles.indexOf(veh)))

  def removeVehicleByType(typeOfVehicle: String) = vehicles.map(v => if (v.getClass.getTypeName == "Garage." + typeOfVehicle) vehicles.remove(vehicles.indexOf(v)))

  //Register Employee and Remove Employee from Garage
  def registerEmployee(employee: Employee) = employees += employee

  def removeEmplopyee(employee: Employee) = employees.remove(employees.indexOf(employee))

  //
  def instantiateParts() = {
    for (i <- 0 to 15) allparts.insert(i, new Part(i, "Part " + i, i + 10, i + 1))
  }

  def displayParts() = allparts.foreach(part => println(part))

  def getRandomPartsList() = {
    val x = computerGuess.nextInt(15 - 5) + 5
    val newlist = allparts.takeWhile(p => allparts.indexOf(p) < x)
    newlist.map(part => if (part.id % 2 == 0) part.isBroken = true)
    newlist

  }

  def instantiateCars(): Unit = {
    addVehicle(new Car(1, "Audi A6", 4, "YG10BET", getRandomPartsList()))
    addVehicle(new Bike(2, "Yamaha Ninja", 2, "YG17REP", getRandomPartsList()))
    addVehicle(new Car(3, "BMW 5 series", 4, "RT12GTH", getRandomPartsList()))
    addVehicle(new Bike(4, "Suzuki Hayaboussa", 2, "FG56GFD", getRandomPartsList()))
    addVehicle(new Car(5, "Mercedes C", 4, "YH10BER", getRandomPartsList()))
    addVehicle(new Bike(6, "Yamaha Ninja", 2, "YG17REP", getRandomPartsList()))
    addVehicle(new Car(7, "Audi A4", 4, "Y10BET", getRandomPartsList()))
    addVehicle(new Bike(8, "Yamaha Ninja2", 2, "YG7REP", getRandomPartsList()))
    addVehicle(new Car(9, "Audi A1", 4, "YG10BT", getRandomPartsList()))
    addVehicle(new Bike(10, "Yamaha Ninja1", 2, "Y17RP", getRandomPartsList()))
  }

  def instantiateEmployees()={
    registerEmployee(new Employee(0,"Adam Smith",25,"0744383488343",true))
    registerEmployee(new Employee(1,"Ryan Smith",35,"0744383488343",true))
    registerEmployee(new Employee(2,"Lee Smith",45,"0744383487343",true))
    registerEmployee(new Employee(3,"Mat Thomson",43,"0744383488343",true))
    registerEmployee(new Employee(4,"Lee Cooper",28,"0744383488343",true))
    registerEmployee(new Employee(5,"Jay Afins",34,"0744383488343",true))
    registerEmployee(new Employee(6,"George Troffin",29,"0744383488343",true))
  }
  def instantiateCustomers()={

  }
  //Open Garage
  def openGarage () = {

  }


  def outputVehicles() = vehicles.foreach(item => println(item))

  def outputEmployees() = employees.foreach(emp => println(emp))

}
