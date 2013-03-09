package worksheets

object HigherOrderFunctions {
  def values(fun: (Int) => Int, low: Int, high: Int) = {
  	require(low < high)
  	
  	low to high map (x => (x,fun(x)))
  }
  
  val a = values(x => x*x, -5, 5)
  1 to 3 reduceLeft (_*_)
  
  def unless (condition: Boolean)(block: => Unit) = {
  	if(!condition) block
  }
  
  val big = 9
  val small = 6
  
  unless (big > small) {
  	println("big is smaller")
  }
}