package worksheets

object PascalTriagle {

	def pascal(r: Int, c: Int): Int = {
		def pascalTri(i: Int, r: Int, arr: Array[Array[Int]]): Array[Array[Int]] ={
			if(i == r) arr
			else
				arr(i) = generateRow(i, arr)
				pascalTri(i+1, r, arr)
		}
		
		
		def generateRow(y: Int, arr: Array[Array[Int]]): Array[Int] = {
	  	if(y==0)
	  		Array(1)
	  	else
	  		new Array[Int](y+1).zipWithIndex map (x => if(x._2 == 0) 1 else if(x._2<y) x._1+arr(y-1)(x._2)+arr(y-1)(x._2-1) else 1)
	  }
  	
		val tri = pascalTri(0, r, new Array[Array[Int]](r))
		tri(r)(c)
	}                                         //> pascal: (r: Int, c: Int)Int
  
	pascal(3, 2)                              //> java.lang.NegativeArraySizeException
                                                  //| 	at worksheets.PascalTriagle$$anonfun$main$1.generateRow$1(worksheets.Pas
                                                  //| calTriagle.scala:16)
                                                  //| 	at worksheets.PascalTriagle$$anonfun$main$1.pascalTri$1(worksheets.Pasca
                                                  //| lTriagle.scala:9)
                                                  //| 	at worksheets.PascalTriagle$$anonfun$main$1.pascal$1(worksheets.PascalTr
                                                  //| iagle.scala:19)
                                                  //| 	at worksheets.PascalTriagle$$anonfun$main$1.apply$mcV$sp(worksheets.Pasc
                                                  //| alTriagle.scala:23)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$$anonfun$$exe
                                                  //| cute$1.apply$mcV$sp(WorksheetSupport.scala:76)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.redirected(W
                                                  //| orksheetSupport.scala:65)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$execute(Wor
                                                  //| ksheetSupport.scala:75)
                                                  //| 	at worksheets.PascalTriagle$.main(worksheets.PascalTriagle.scala:3)
                                                  //| 	at worksheets.PascalTriagle.main(worksheets.PascalTriagle.scala)
  
}