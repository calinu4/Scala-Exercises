import scala.collection.mutable.ArrayBuffer

//Task 1
def doubleChar(word:String)= {
  var result=""
  word.toCharArray.foreach(e=>result+=e.toString+e.toString)
  result
}
println(doubleChar("The"))
println(doubleChar("AAbb"))
println(doubleChar("Hi-There"))

//Task 2 =I know how to check if it contains the bread at beginning and at the end of the string but don't really know how to get
//only the string in between
def getSandwich(word:String)={
word.split("bread").mkString
}
getSandwich("breadjambread")

//Task3
def evenlySpaced(a:Int,b:Int,c:Int)={
  var list:Array[Int]=Array(a,b,c).sorted
  if((list(1)-list(0))==list(2)-list(1)) true else false
}
println("Numbers are evenly spaced= "+evenlySpaced(2,4,6))
println("Numbers are evenly spaced= "+evenlySpaced(4,2,6))
println("Numbers are evenly spaced= "+evenlySpaced(27,15,12))

//Task4//somehow fibonaci(n)=fibonaci(n-1)+fibonaci(n-2) but don't really know how to keep track of the first two
var res=0
def fibonacci(n:Int):Int= {
  if(n==0)0
  if(n==1)1
  var counter=2
    if(counter<=n) {//counter+=1
      res = res + fibonacci(counter - 1) + fibonacci(counter - 2)
    }
  return res
}
println("Fibonacci result: "+fibonacci(4))

//Task 5
def bunnyEars(bunnyNumber:Int)=bunnyNumber*2
println("Total ears for 4 bunnies: "+bunnyEars(4))
println("Total ears for 2 bunnies: "+bunnyEars(2))

//Task 6
def nTwice(word:String,n:Int)=word.substring(0,n)+word.substring(word.length-n)

println(nTwice("Hello",2))
println(nTwice("Chocolate", 3))
println(nTwice("Chocolate", 1))

//Task 7
def endsLy(word:String)=word.endsWith("ly")
println("oddly ends with ly is: "+endsLy("oddly"))
println("y ends with ly is: "+endsLy("y"))
println("oddy ends with ly is: "+endsLy("oddy"))

//Task 8

def stringClean(word:String):String={
/*
 // var list:ArrayBuffer[Char]=new ArrayBuffer[Char]
  for(i<-0 until word.length-1) {
    if (word.charAt(i) == word.charAt(i + 1)){
      var res=word.drop(i)
      stringClean(res)
    }
  }*/
  word.distinct

}
println(stringClean("abba"))

//Task 9
def diamondChars(c:Char,n:Int)={
}
