package Garage

import scala.collection.mutable.ListBuffer

/**
  * Created by Profile on 12/06/2017.
  */
object Garage {
  var vehicles: ListBuffer[Vehicle]=new ListBuffer[Vehicle]
  var employees:ListBuffer[Person]=new ListBuffer[Person]

  def addVehicle(vehicle:Vehicle)={
    vehicles.insert(1,vehicle)
  }

}
