//BlackJack
  def returnBlackJack(first: Int, second: Int): Int = (first, second) match {
    case values if (values._1 > 21 && values._2 > 21) => 0
    case values if (values._1 <= 21 && values._1 >= values._2 || values._1 <= 21 && values._2 > 21) => values._1
    case values if (values._2 <= 21 && values._2 >= values._1 || values._2 <= 21 && values._1 > 21) => values._2
    case _ => 0
  }
  println("Result of BlackJack: " + returnBlackJack(22, 15))
def returnUniqueSum(first: Int, second: Int, third: Int): Int = (first, second, third) match {
    case nums if (nums._1 != nums._2 && nums._1 != nums._3 && nums._2 != nums._3) => nums._1 + nums._2 + nums._3
    case n if (n._1 == n._2 && n._2 != n._3) => n._3
    case n if (n._1 == n._3 && n._2 != n._3) => n._2
    case n if (n._2 == n._3 && n._1 != n._2) => n._1
    case n if (n._1 == n._2 && n._2 == n._3) => 0
    case _ => 0
  }
  println("Sum Result: " + returnUniqueSum(1, 3, 4))

  def returnIsTooHot(isSummer:Boolean,temp:Int):Boolean=(isSummer,temp) match{
    case tuple if((tuple._1&&tuple._2>=60&&tuple._2<=100)||(tuple._1)!=true&&tuple._2>=60&&tuple._2<=90)=>true
    case tuple if((tuple._1&&tuple._2<60||tuple._2>100)||(tuple._1)!=true&&tuple._2<60||tuple._2>90)=>false
  }

  println("Input(false,80) "+returnIsTooHot(false,85))
  println("Input(true,100) "+returnIsTooHot(true,100))
  println("Input(false,100) "+returnIsTooHot(false,100))


