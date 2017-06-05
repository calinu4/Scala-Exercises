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
    return "Hello World! returned from method"
  }

  def returnAnything(somevar: Any): Any = {
    return somevar

  }

  def returnSubstring(word: String, size: Int): String = {
    val wordsize = word.size
    var result = ""
    for (i <- wordsize - size to wordsize - 1) {
      result += word.charAt(i)
    }
    return result
  }

  println(returnSubstring("Hello", 3))

  def returnString2(word1: String, word2: String, c1: Char, c2: Char): String = {
    var result = word1.concat(word2)

    result=result.replace(c1,c2)
    return result

  }
  println("Result of string replace1: "+returnString2("Ha","llo",'a','e'))
}