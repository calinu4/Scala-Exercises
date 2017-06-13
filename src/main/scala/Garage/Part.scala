package Garage

/**
  * Created by Profile on 13/06/2017.
  */
class Part(id1:Int,title1:String,price1:Double,hoursToRepair:Int) {
  def id:Int=id1
  def title:String=title1
  def price:Double=price1
  def repairHours:Int=hoursToRepair
  var isBroken:Boolean=false

  override def toString: String = "Id: "+id+", Title: "+title+", Price: "+price+"£, Time to Repair: "+repairHours+", IsBroken="+isBroken
}
