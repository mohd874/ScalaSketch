package worksheets

object Test {
  def values(fun: (Int) => Int, low: Int, high: Int) = {
  	require(low < high)
  	
  	low to high map (x => (x,fun(x)))
  }                                               //> values: (fun: Int => Int, low: Int, high: Int)scala.collection.immutable.Ind
                                                  //| exedSeq[(Int, Int)]
  
  val a = values(x => x*x, -5, 5)                 //> a  : scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((-5,25), (-4
                                                  //| ,16), (-3,9), (-2,4), (-1,1), (0,0), (1,1), (2,4), (3,9), (4,16), (5,25))
  1 to 3 reduceLeft (_*_)                         //> res0: Int = 6
  
  def unless (condition: Boolean)(block: => Unit) = {
  	if(!condition) block
  }                                               //> unless: (condition: Boolean)(block: => Unit)Unit
  
  val big = 9                                     //> big  : Int = 9
  val small = 6                                   //> small  : Int = 6
  
  unless (big > small) {
  	println("big is smaller")
  }
}