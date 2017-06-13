package Garage

import scala.collection.mutable.ListBuffer

class Bike(id1:Int,mod:String,tyr:Int,reg:String,parts1:ListBuffer[Part]) extends Vehicle{
  def id:Int=id1
  def model: String = mod
  def tyres:Int=tyr
  def registration:String=reg
  var parts:ListBuffer[Part]=parts1
  override def toString: String = "Bike => "+super.toString

}
