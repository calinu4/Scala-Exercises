/**
  * Created by Profile on 05/06/2017.
  */
object Main {

  def main(args: Array[String]): Unit = {
    //Basic exercises
    println("Hello World")

    var output="Hello World"
    println("Printing from variable: "+output)
    outputString("Hello World")
    println(returnString())

    println("Test data type=string: "+returnAnything("Hey"))
    println("Test data type=double: "+returnAnything(2.98))
    println("Test data type=int: "+returnAnything(10))
    println("Test data type=boolean: "+returnAnything(true))
    
  }

  def outputString(inputString:String){
    println("Printing from method: "+inputString)

  }

  def returnString():String={
    return "Hello World! returned from method"
  }

  def returnAnything(somevar:Any):Any={
    return somevar

  }
}
