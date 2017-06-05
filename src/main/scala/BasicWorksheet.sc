object BasicWorksheet {
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
    val wordsize = word.size
    var result = ""
    for (i <- wordsize - size to wordsize - 1) {
      result += word.charAt(i)
    }
    result
  }

  println(returnSubstring("Hello", 3))

  def returnString2(word1: String, word2: String, c1: Char, c2: Char): String = {
    var result = word1.concat(word2)

    result = result.replace(c1, c2)
    result

  }

  println("Result of string replace1: " + returnString2("Ha", "llo", 'a', 'e'))

  def returnSum(num1: Int, num2: Int): Int = {
    return num1 + num2
  }

  println("Sum of 7+8=: " + returnSum(7, 8))

  def returnSumCondition(num1: Int, num2: Int, isTrue: Boolean): Int = {
    if (isTrue)
      num1 + num2;
    else
      num1 * num2
  }

  println("Result conditional one: " + returnSumCondition(7, 8, false))

  def returnCondition2(num1: Int, num2: Int): Int = {
    if (num1 == 0 && num2 == 0)
      num1
    else if (num1 == 0)
      num2
    else
      num1
  }

  println("Second conditional: " + returnCondition2(4, 6))

  def printOutStrings(word: String, times: Int): Unit = {
    for (i <- 1 to times)
      println(word)

  }

  printOutStrings("Hi", 3)

  def printOutStringSquared(word: String, times: Int): Unit = {
    var result = ""
    for (i <- 1 to times)
      result += word + " "

    for (j <- 1 to times)
      println(result)
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
      printOutStrings(word, times)
  }

  printOutStringsRecursion("Hi", 5)

  def printOutStringSquaredRecursion(word: String, times: Int): Unit = {

    var result = ""
    for (i <- 1 to times)
      result += word + " "
    println(result+" ")


    if (times >= 1)
      printOutStringSquaredRecursion(word, times-1)


  }

  printOutStringSquaredRecursion("H", 4)
}