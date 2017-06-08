import scala.collection.mutable.ArrayBuffer
def calculator(a: Int, b: Int, c: Int) = {
  var list: Array[Int] = Array(a, b, c)
  var results:ArrayBuffer[String]=new ArrayBuffer[String]
  var elem1 = 0 var elem2 = 0 var elem3 = 0
  for (i <- 0 to list.length - 1) {
    i match {
      case 0 => {
        elem1 = list(i)
        elem2 = list(i + 1)
        elem3 = list(i + 2)
      }
      case 1 => {
        elem1 = list(i)
        elem2 = list(i - 1)
        elem3 = list(i + 1)
      }
      case 2 => {
        elem1 = list(i)
        elem2 = list(i - 1)
        elem3 = list(i - 2)
      }
      case _ => "no solution"
    }
    //do operations on two elements here
    if(elem1==add(elem2,elem3)) results+=elem2+"+"+elem3+"="+elem1
    if(elem1==substract(elem2,elem3)) results+=elem2+"-"+elem3+"="+elem1
    if(elem1==multiply(elem2,elem3)) results+=elem2+"*"+elem3+"="+elem1
    if(elem1==divide(elem2,elem3)) results+=elem2+"/"+elem3+"="+elem1

    if(elem1==substract(elem3,elem2)) results+=elem3+"-"+elem2+"="+elem1
    if(elem1==divide(elem3,elem2)) results+=elem3+"/"+elem2+"="+elem1
  }
  results=results.distinct
  results.foreach(item=>println(item))


}

def add(x: Int, y: Int) = {
  x + y
}
def substract(x: Int, y: Int) = {
  x - y
}
def multiply(x: Int, y: Int) = {
  x * y
}
def divide(x: Int, y: Int) = {
  x / y
}
calculator(4, 2, 8)
calculator(6, 2, 12)
calculator(9,12 , 108)
calculator(4, 16, 64)