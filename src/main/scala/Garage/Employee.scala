package Garage

/**
  * Created by Profile on 12/06/2017.
  */
class Employee(id1:Int,name1:String,age1:Int,phoneNumber:String,isAv:Boolean) extends Person {
  def id:Int=id1
  def name:String=name1
  def age:Int=age1
  def phone:String=phoneNumber
  var isAvailable:Boolean=isAv

  override def toString: String = "Employee=> "+super.toString+", IsAvailable="+isAvailable



}
