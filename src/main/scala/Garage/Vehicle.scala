package Garage

/**
  * Created by Profile on 12/06/2017.
  */
abstract class Vehicle {
  def model:String
  def tyres:Int
  def registration:String

  override def toString: String = "Model: "+model+", "+"Tyres="+tyres+", "+"Registration: "+registration
}
