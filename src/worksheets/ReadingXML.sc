package src.worksheets

import xml._

object ReadingXML {
  val fileLoc = "/Users/mohd874/Desktop/208.xml"  //> fileLoc  : java.lang.String = /Users/mohd874/Desktop/208.xml
  
  val source = io.Source.fromFile(fileLoc)        //> java.io.FileNotFoundException: \Users\mohd874\Desktop\208.xml (The system ca
                                                  //| nnot find the path specified)
                                                  //| 	at java.io.FileInputStream.open(Native Method)
                                                  //| 	at java.io.FileInputStream.<init>(Unknown Source)
                                                  //| 	at scala.io.Source$.fromFile(Source.scala:91)
                                                  //| 	at scala.io.Source$.fromFile(Source.scala:76)
                                                  //| 	at scala.io.Source$.fromFile(Source.scala:54)
                                                  //| 	at src.worksheets.ReadingXML$$anonfun$main$1.apply$mcV$sp(src.worksheets
                                                  //| .ReadingXML.scala:8)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$$anonfun$$exe
                                                  //| cute$1.apply$mcV$sp(WorksheetSupport.scala:76)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.redirected(W
                                                  //| orksheetSupport.scala:65)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$execute(Wor
                                                  //| ksheetSupport.scala:75)
                                                  //| 	at src.worksheets.ReadingXML$.main(src.worksheets.ReadingXML.scala:5)
                                                  //| 	at src.worksheets.ReadingXML.main(src.worksheets.ReadingXML.scala)
  
  val fileString = source mkString
  
  val seq = XML.loadString(fileString)
  
  val items = seq \ "channel" \\ "item"
  
  items.length
  
  for (item <- items){
  	if((item \ "title" text) == "[HorribleSubs] Fairy Tail - 170 [1080p].mkv"){
  		println("Found title")
  		//println(item \\ "magnetURI" text)
  		val guid = (item \\ "guid").text
  		println(guid)
  	}
  }
  
  source close
  
  val data = XML.loadFile("c:/food.xml")
  data \\ "type" filter (_.text == "viel")

	(data \\ "bar" \\ "@class" toList) map (_.text) contains ("meat")
	
	data \\ "bar" filter (b => (b \\ "@class" toList) map (_.text) contains ("veggi"))
}