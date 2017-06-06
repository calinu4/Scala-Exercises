object IntermediateWorksheet{
//BlackJack
  def returnBlackJack(first:Int,second:Int):Int=(first,second) match{
    case values if(values._1>21&&values._2>21)=>0
    case values if(values._1<=21&&values._1>=values._2||values._1<=21&&values._2>21)=>values._1
    case values if(values._2<=21&&values._2>=values._1||values._2<=21&&values._1>21)=>values._2
    case _ =>0
  }
  println("Result of BlackJack: "+returnBlackJack(20,15))







}