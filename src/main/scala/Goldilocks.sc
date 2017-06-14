import scala.collection.mutable.ListBuffer
val person = Array(100, 120)
val table = Map(1-> Array(297, 90), 2 -> Array(66, 110), 3 -> Array(257, 113), 4 -> Array(276, 191), 5 -> Array(280, 129), 6 -> Array(219, 163),
  7 -> Array(254, 193),8->Array(86,153),9->Array(206,147),10->Array(71,137),11->Array(104,40),12->Array(238,127),13->Array(52,146),14->Array(129,197),
15->Array(144,59),16->Array(157,124),17->Array(210,59),18->Array(11,54),19->Array(268,119),20->Array(261,121),21->Array(12,189),22->Array(186,108),
  23->Array(174,21),24->Array(77,18),25->Array(54,90),26->Array(174,52),27->Array(16,129),28->Array(59,181),29->Array(290,123),30->Array(248,132))

def showAvailableSeats(pers: Array[Int], tab: Map[Int, Array[Int]]) = {
  var availableSeats: ListBuffer[Int] = ListBuffer[Int]()
  tab.foreach(key => if (person(0) <= key._2(0) && person(1) >= key._2(1)) availableSeats+=key._1)
  availableSeats.sorted.foreach(seat=>print(seat+" "))
}
showAvailableSeats(person, table)