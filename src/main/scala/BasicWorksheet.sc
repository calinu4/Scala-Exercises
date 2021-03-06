//Basic exercises
println("Hello World")
var output = "Hello World"
println("Printing from variable: " + output)
outputString("Hello World")
println(returnString())
println("Test data type=string: " + returnAnything("Hey"))
println("Test data type=double: " + returnAnything(2.98))
println("Test data type=int: " + returnAnything(10))
println("Test data type=boolean: " + returnAnything(true))

def outputString(inputString: String) {
  println("Printing from method: " + inputString)
}

def returnString(): String = {
  "Hello World! returned from method"
}

def returnAnything(somevar: Any): Any = {
  somevar
}

def returnSubstring(word: String, size: Int): String = {
  word.map(letter => letter).filter(item => word.indexOf(item) >= word.size - size).mkString
}
println(returnSubstring("Hello", 3))

def returnString2(word1: String, word2: String, c1: Char, c2: Char): String = {
  word1.concat(word2).replace(c1, c2)
}
println("Result of string replace1: " + returnString2("Ha", "llo", 'a', 'e'))

def returnSum(num1: Int, num2: Int): Int = {
  num1 + num2
}
println("Sum of 7+8=: " + returnSum(7, 8))

def returnSumCondition(num1: Int, num2: Int, isTrue: Boolean): Int = {
  if (isTrue) num1 + num2 else num1 * num2
}
println("Result conditional one: " + returnSumCondition(7, 8, false))

def returnCondition2(num1: Int, num2: Int) = (num1, num2) match {
  case (0, 0) => num1
  case (0, b) => num1
  case _ => num2
}
println("Second conditional: " + returnCondition2(4, 6))

def printOutStrings(word: String, times: Int): Unit = {
  for (i <- 1 to times) println(word)
}
printOutStrings("Hi", 3)

def printOutStringSquared(word: String, times: Int): Unit = {
  var result = ""
  for (i <- 1 to times) result += word + " "
  for (j <- 1 to times) println(result)
}
printOutStringSquared("H", 4)

def fizzBuzz(word1: String, word2: String, size: Int): Unit = {
  for (i <- 1 to size)
    if (i % 3 == 0 && i % 5 == 0)
      print(word1 + word2 + ",")
    else {
      if (i % 3 == 0)
        print(word1 + ",")
      else if (i % 5 == 0)
        print(word2 + ",")
      else
        print(i + ",")
    }
}
fizzBuzz("Fizz", "Buzz", 15)

//rewritte iterations using recursion here
def printOutStringsRecursion(word: String, times: Int): Unit = {
  println(word)
  if (times > 1)
    printOutStrings(word, times - 1)
}
printOutStringsRecursion("Hi", 5)

def printOutStringSquaredRecursion(word: String, times: Int, iteration: Int, counter: Int): Unit = {
  print(word + " ")
  if (counter >= times && iteration >= 1) {
    println()
    printOutStringSquaredRecursion(word, times, iteration - 1, 1)
  }
  else if (iteration >= 1)
    printOutStringSquaredRecursion(word, times, iteration, counter + 1)
}
printOutStringSquaredRecursion("H", 4, 4, 1)

def fizzBuzzRecursion(word1: String, word2: String, size: Int, currentPos: Int): Unit = {
  if (size >= 1) {
    if (currentPos % 3 == 0 && currentPos % 5 == 0)
      print(word1 + word2 + ",")
    else {
      if (currentPos % 3 == 0)
        print(word1 + ",")
      else if (currentPos % 5 == 0)
        print(word2 + ",")
      else
        print(currentPos + ",")
    }
    fizzBuzzRecursion(word1, word2, size - 1, currentPos + 1)
  }
}
fizzBuzzRecursion("fizz", "buzz", 15, 1)

//Pattern matching 1 exercises
def returnPattern1(num1: Int, num2: Int, isTrue: Boolean): Any = isTrue match {
  case true => num1 + num2
  case false => num1 * num2
}
println("Pattern matching 1 first condition: " + returnPattern1(7, 8, true))

def returnPattern1Condition2(any: Any): Any = any match {
  case (0, 0) => 0
  case (0, y) => y
  case (x, 0) => x
}
println("Return pattern 1 tupple: " + returnPattern1Condition2(4, 0))
//Pattern matching 2 exercises swapping numbers


def switchNumbers1(any: Any) = any match {
  case Array(x, y, z@_*) => Array(y, x)
  case List(x, y, z@_*) => List(y, x)
  case tuple@(a: Any, b: Any) => tuple.swap
  case _ => any
}

var numbers1 = Array(5, 9, 11, 12)
var numbers2 = List(4, 8, 45)
val tupple = (3, 6)
switchNumbers1(numbers1)
switchNumbers1(numbers2)
switchNumbers1(tupple)

def functionTimes() = {
  java.util.TimeZone.getAvailableIDs().map(a => a.split('/')).filter(_.length > 1).map(b => b(1)).grouped(50).map(c => c(0)).toArray.foreach(item => println(item))
}
functionTimes()


