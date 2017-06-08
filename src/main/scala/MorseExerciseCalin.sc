val morseMessage:String=".... . .-.. .-.. --- / -.. .- .. .-.. -.-- / .--. .-. --- --. .-. .- -- -- . .-. / --. --- --- -.. / .-.. ..- -.-. -.- / --- -. / - .... . / -.-. .... .- .-.. .-.. . -. --. . ... / - --- -.. .- -.--"
val map1=Map(".-"->'A',"-..."->'B',"-.-."->'C',"-.."->'D',"."->'E',"..-."->'F',"--."->'G',"...."->'H',".."->'I',".---"->'J',"-.-"->'K',".-.."->'L',"--"->'M',"-."->'N',"---"->'O',
  ".--."->'P',"--.-"->'Q',".-."->'R',"..."->'S',"-"->'T',"..-"->'U',"...-"->'V',".--"->'W',"-..-"->'X',"-.--"->'Y',"--.."->'Z',"-----"->'0',".----"->'1',"..---"->'2',"...--"->'3',
  "....-"->'4',"....."->'5',"-...."->'6',"--..."->'7',"---.."->'8',"----."->'9'," "->' ',"/"->' ')
val map2=map1.map(_.swap)
def morseCodeTranslator(message:String)={
  message.split('/').flatMap(item=>item.split(' ')).map(item=>map1.getOrElse(item," ")).mkString
}
def humanToMorseCode(message:String)= {
  message.toCharArray.flatMap(item =>map2.getOrElse(item," ")+" ").mkString
}
val humanMessage=morseCodeTranslator(morseMessage)
val newMorse=humanToMorseCode(humanMessage)
print(morseCodeTranslator(newMorse))
