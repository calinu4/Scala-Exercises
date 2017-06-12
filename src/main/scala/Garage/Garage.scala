package Garage

import scala.collection.mutable.ListBuffer

/**
  * Created by Profile on 12/06/2017.
  */
object Garage {
  var vehicles: ListBuffer[Vehicle]=new ListBuffer[Vehicle]
  var employees:ListBuffer[Person]=new ListBuffer[Person]

  def main(args: Array[String]): Unit = {
    addVehicle(new Car(1,"Audi A6",4,"YG10BET"))
    addVehicle(new Bike(2,"Yamaha Ninja",2,"YG17REP"))
    removeVehicleByType("Car")
    outputVehicles()

  }

  def addVehicle(vehicle:Vehicle)={
    vehicles+=vehicle
  }

  def removeVehicleById(id:Int)={
    vehicles.map(veh=>if(veh.id==id)vehicles.remove(vehicles.indexOf(veh)))
  }



  def removeVehicleByType(typeOfVehicle:String)= {

      vehicles.map(v=>if (v.getClass.getTypeName=="Garage."+typeOfVehicle) vehicles.remove(vehicles.indexOf(v)))


  }

  def outputVehicles()={
    vehicles.foreach(item=>println(item))
  }

}
