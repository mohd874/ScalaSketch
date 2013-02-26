package worksheets

object Arrays {
  val a: Array[Int] = Array(1,2,3,4,5)
  val b = Array(Array(1,2),Array(3,4))
  
  a map (x => x*x)
  a
  
  b.flatten
  
  b.flatten zipWithIndex
  
  a ++ b
  def generateRow(y: Int, arr: Array[Array[Int]]): Array[Array[Int]] = {
	  	if(y==0)
	  		Array(Array(1))
	  	else
	  		new Array[Int](y+1).zipWithIndex map (x => if(x._2 == 0) 1 else if(x._2<y) x._1+arr(y-1)(x._2)+arr(y-1)(x._2-1) else 1) ++ generateRow(y-1, arr)
	}
  	
}