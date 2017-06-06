object IntermediateWorksheet{
//BlackJack
  def returnBlackJack(first:Int,second:Int):Int=(first,second) match{
    case values if(values._1>21&&values._2>21)=>0
    case values if(values._1<=21&&values._1>=values._2||values._1<=21&&values._2>21)=>values._1
    case values if(values._2<=21&&values._2>=values._1||values._2<=21&&values._1>21)=>values._2
    case _ =>0
  }
  println("Result of BlackJack: "+returnBlackJack(20,15))

  def returnUniqueSum(first:Int,second:Int,third:Int):Int=(first,second,third) match{
    case nums if(nums._1!=nums._2&&nums._1!=nums._3&&nums._2!=nums._3)=>nums._1+nums._2+nums._3
    case n if(n._1==n._2&&n._2!=n._3)=>n._3
    case n if(n._1==n._3&&n._2!=n._3)=>n._2
    case n if(n._2==n._3&&n._1!=n._2)=>n._1
    case n if(n._1==n._2&&n._2==n._3)=>0
    case _=>0
  }
println("Sum Result: "+returnUniqueSum(1,3,4))






}