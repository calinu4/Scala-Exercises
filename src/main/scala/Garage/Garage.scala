package Garage

import scala.collection.mutable.ListBuffer

/**
  * Created by Profile on 12/06/2017.
  */
object Garage {
  var vehicles: ListBuffer[Vehicle]=new ListBuffer[Vehicle]
  var employees:ListBuffer[Person]=new ListBuffer[Person]
  var allparts:ListBuffer[Part]=new ListBuffer[Part]

  def main(args: Array[String]): Unit = {
    instantiateParts()
   addVehicle(new Car(1,"Audi A6",4,"YG10BET",allparts))
    addVehicle(new Bike(2,"Yamaha Ninja",2,"YG17REP",allparts))
   // removeVehicleByType("Car")
    outputVehicles()
    displayParts()

  }

  //Add, Remove By Id and Remove By Type
  def addVehicle(vehicle:Vehicle)=vehicles+=vehicle
  def removeVehicleById(id:Int)=vehicles.map(veh=>if(veh.id==id)vehicles.remove(vehicles.indexOf(veh)))
  def removeVehicleByType(typeOfVehicle:String)=vehicles.map(v=>if (v.getClass.getTypeName=="Garage."+typeOfVehicle) vehicles.remove(vehicles.indexOf(v)))

  //Register Employee and Remove Employee from Garage
  def registerEmployee(employee: Employee)=employees+=employee
  def removeEmplopyee(employee: Employee)=employees.remove(employees.indexOf(employee))

  //
  def instantiateParts()={
    for(i<-0 to 15) allparts.insert(i,new Part(i,"Part "+i,i+10,i+1))
  }
  def displayParts()=allparts.foreach(part=>println(part))

  def getRandomPartsList()={

  }



  def outputVehicles()= vehicles.foreach(item=>println(item))
  def outputEmployees()=employees.foreach(emp=>println(emp))

}
