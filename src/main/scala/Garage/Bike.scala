package Garage

class Bike(mod:String,tyr:Int,reg:String) extends Vehicle{
  def model: String = mod
  def tyres:Int=tyr
  def registration:String=reg

  override def toString: String = "Bike => "+super.toString

}
