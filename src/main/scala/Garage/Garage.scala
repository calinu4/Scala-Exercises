package Garage

import scala.collection.mutable._


/**
  * Created by Profile on 12/06/2017.
  */
object Garage {
  var vehicles: ListBuffer[Vehicle] = new ListBuffer[Vehicle]
  var employees: ListBuffer[Employee] = new ListBuffer[Employee]
  var customers: ListBuffer[Customer] = new ListBuffer[Customer]
  var allparts: ListBuffer[Part] = new ListBuffer[Part]
  var customerVehiclesMap: Map[Vehicle, Customer] = scala.collection.mutable.Map[Vehicle, Customer]()
  var computerGuess = scala.util.Random
  var fixMap:Map[Vehicle,Employee]=scala.collection.mutable.Map[Vehicle,Employee]()

  val hourlyRate = 30
  var maxHoursPerDay = 0
  var totalHours=0
  var totalDays=0
  def main(args: Array[String]): Unit = {
    instantiateEmployees()
    instantiateParts()
    openGarage()

    //outputVehiclesWithCustomers()
    println("Total time to fix the vehicles is: "+totalDays+" Day")
    println("Total money to repair first car "+calculateBill(vehicles(0)))
    closeGarage()


  }

  //Add, Remove By Id and Remove By Type
  def addVehicle(vehicle: Vehicle) = vehicles += vehicle

  def removeVehicleById(id: Int) = vehicles.map(veh => if (veh.id == id) vehicles.remove(vehicles.indexOf(veh)))

  def removeVehicleByType(typeOfVehicle: String) = vehicles.map(v => if (v.getClass.getTypeName == "Garage." + typeOfVehicle) vehicles.remove(vehicles.indexOf(v)))

  //Register Employee and Remove Employee from Garage
  def registerEmployee(employee: Employee) = employees += employee

  def removeEmplopyee(employee: Employee) = employees.remove(employees.indexOf(employee))

  //Register Customers and map them to the vehicles
  def registerCustomer(cust: Customer) = customers += cust

  def removeCustomer(cust: Customer) = customers.remove(customers.indexOf(cust))

  //Instantiate a sample list of parts
  def instantiateParts() = {//for testing purposes I assume that all parts will take one hour to be fixed so we can fix one car under one day
    for (i <- 0 to 15) allparts.insert(i, new Part(i, "Part " + i, i + 10, 1))
  }

  //Return a random list of parts for each vehicles
  def getRandomPartsList() = {
    val x = computerGuess.nextInt(15 - 10) + 10
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

  def instantiateEmployees() = {
    registerEmployee(new Employee(0, "Adam Smith", 25, "0744383488343", true))
    registerEmployee(new Employee(1, "Ryan Smith", 35, "0744383488343", true))
    registerEmployee(new Employee(2, "Lee Smith", 45, "0744383487343", true))
    registerEmployee(new Employee(3, "Mat Thomson", 43, "0744383488343", true))
    registerEmployee(new Employee(4, "Lee Cooper", 28, "0744383488343", true))
    registerEmployee(new Employee(5, "Jay Afins", 34, "0744383488343", true))
    registerEmployee(new Employee(6, "George Troffin", 29, "0744383488343", true))
  }

  def instantiateCustomers() = {
    registerCustomer(new Customer(0, "Louie Adam", 33, "077434747642"))
    registerCustomer(new Customer(1, "Rya Thom", 21, "077435657642"))
    registerCustomer(new Customer(2, "Bea Elize", 36, "0774354547642"))
    registerCustomer(new Customer(3, "Clark Denis", 38, "0774747642"))
    registerCustomer(new Customer(4, "Dan Brian", 43, "077434747642"))
    val list = customers.toList
    vehicles.foreach(v => customerVehiclesMap.put(v, list(computerGuess.nextInt(5))))
  }

  //Open Garage
  def openGarage() = {
    instantiateCars()
    instantiateCustomers()
    totalHours=returnTotalTimeToRepairAllVehicles()
    maxHoursPerDay=returnMaxHoursPerDay()
    totalDays=convertHoursToDays(totalHours)
    vehicles.foreach(veh=>fixVehicle(veh))
    //show the vehicles which are attended by employees
    fixMap.foreach(veh=>println(veh._1.model+"   ->    "+veh._2.name+"     Time to fix: "+returnTotalHoursPerVehicleToFix(veh._1)+"   Total cost to fix: £"+calculateBill(veh._1)))
  }

  def closeGarage()={
calculateTotalProfitForOneDay()
  }

  //Fix Vehicle
  def fixVehicle(veh: Vehicle) = {
    var isDone:Boolean=false
     employees.foreach(emp=>if(emp.isAvailable && !isDone){fixMap.put(veh,emp);emp.isAvailable=false;isDone=true})


  }

  def returnTotalHoursPerVehicleToFix(v:Vehicle)={
    var totalHours=0
    v.parts.foreach(part=>if(part.isBroken)totalHours+=part.repairHours)
    totalHours

  }
  def returnTotalPriceForParts(v:Vehicle)={
    var totalpartsPrice=0
    v.parts.foreach(item=>if(item.isBroken)totalpartsPrice+=item.price)
    totalpartsPrice
  }
  def returnTotalTimeToRepairAllVehicles()={
    var totalTime=0
    vehicles.foreach(item=>totalTime+=returnTotalHoursPerVehicleToFix(item))
    totalTime
  }
  def convertHoursToDays(hours:Int)={
    var totaldays=hours/maxHoursPerDay
    if(totaldays<=1)totaldays=1
    else
      if(totalHours-(totaldays*maxHoursPerDay)>=1) totaldays+1
    totaldays
  }

  def returnMaxHoursPerDay()={
    employees.foreach(emp=>if(emp.isAvailable)maxHoursPerDay+=8)
    maxHoursPerDay
  }
  def calculateBill(v:Vehicle)={
    var bill=returnTotalHoursPerVehicleToFix(v)*30+returnTotalPriceForParts(v)
    bill

  }

  def calculateTotalProfitForOneDay()={
    var totalBill=0
    fixMap.foreach(veh=>totalBill+=calculateBill(veh._1))
    println("Total Profit for one day: "+totalBill)

  }
  def outputVehicles() = vehicles.foreach(item => println(item))

  def outputEmployees() = employees.foreach(emp => println(emp))

  def outputVehiclesWithCustomers() = {
    customerVehiclesMap.foreach(f => println(f._1 + " " + f._2))
  }
}
