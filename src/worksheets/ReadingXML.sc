package src.worksheets

import xml._

object ReadingXML {
  def nums = List(1,5,4,2)                        
  
  (nums map (x=>x*x)) reduceLeft (_+_)           
  
  val fileLoc = "/Users/mohd874/Desktop/208.xml"  
  
  val source = io.Source.fromFile(fileLoc)        
  
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
  
  
  
}