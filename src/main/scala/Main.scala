/**
  * Created by Profile on 05/06/2017.
  */
object Main {

  def main(args: Array[String]): Unit = {
    println("Hello World")

    var output="Hello World"
    println("Printing from variable: "+output)
    outputString("Hello World")
    println(returnString())
  }

  def outputString(inputString:String){
    println("Printing from method: "+inputString)

  }

  def returnString():String={
    return "Hello World! returned from method"
  }
}
