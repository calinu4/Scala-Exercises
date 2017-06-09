def createRoutes(route:Array[Int])={
  var list: Array[Int] =new Array[Int](480)
  for(i<-0 until 480 by(route.length)){
    if(i<=480-route.length)
    for(j<-0 until route.length)
      list(i+j)=route(j)
  }
//list.foreach(item=>print(item+" "))
  list
}

def checkGossips(drivers:Array[Array[Int]])={

}

val driver1=createRoutes(Array(3,1,2,3))
val driver2=createRoutes(Array(3,2,3,1))
val driver3=createRoutes(Array(4,2,3,4,5))
checkGossips(Array(driver1,driver2,driver3))