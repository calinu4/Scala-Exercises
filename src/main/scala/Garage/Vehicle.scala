package Garage

import scala.collection.mutable.ListBuffer

/**
  * Created by Profile on 12/06/2017.
  */
abstract class Vehicle {
  def id:Int
  def model:String
  def tyres:Int
  def registration:String
  var parts:ListBuffer[Part]
  override def toString: String = "Model: "+model+", "+"Tyres="+tyres+", "+"Registration: "+registration
}
