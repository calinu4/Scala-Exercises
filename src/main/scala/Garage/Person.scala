package Garage

/**
  * Created by Profile on 12/06/2017.
  */
abstract class Person {
  def id:Int
  def name:String
  def age:Int
  def phone:String

  override def toString: String = "Id: "+id+", Name: "+name+", Age: "+age+", Phone: "+phone

}
