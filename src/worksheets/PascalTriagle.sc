package worksheets

object PascalTriagle {
  /*
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
	}  */
  def pascal(r: Int, c: Int) = {
		def nextRow(r: Array[Int], i: Int): Array[Int] = {
			if(i == 0) r
			else{
				val a = r ++: Array(0)
	      val b = Array(0) ++: r
	      nextRow(a zip b map (x => x._1 + x._2), i-1)
      }
		}
    nextRow(Array(1), r)(c)
  }                                               //> pascal: (r: Int, c: Int)Int

  pascal(3, 2)                                    //> res0: Int = 3

}