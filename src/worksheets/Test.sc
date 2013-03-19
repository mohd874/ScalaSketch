package worksheets

import scala.collection.immutable.Stream

object Test {
  val s = 9                                       //> s  : Int = 9
  
  val list = List(1,2,3,4,5)                      //> list  : List[Int] = List(1, 2, 3, 4, 5)
   
  def sum(x: Int, y: Int) = x+y                   //> sum: (x: Int, y: Int)Int
  
  def pow (x: Int) = x*x                          //> pow: (x: Int)Int
  
  list map (pow)                                  //> res0: List[Int] = List(1, 4, 9, 16, 25)
  
  for(n <- list) yield n+2                        //> res1: List[Int] = List(3, 4, 5, 6, 7)
  
  import scala.sys.process._
  
  "java -version" !                               //> java version "1.7.0_05"
                                                  //| Java(TM) SE Runtime Environment (build 1.7.0_05-b06)
                                                  //| Java HotSpot(TM) Client VM (build 23.1-b03, mixed mode, sharing)
                                                  //| res2: Int = 0
                                                  
	val stream1: Stream[Double] = {
	  def loop(v: Double): Stream[Double] = v #:: loop(math.pow(v+1, v+1))
	  loop(0)
 	}                                         //> stream1  : scala.collection.immutable.Stream[Double] = Stream(0.0, ?)
 	
 	stream1 take 3 last                       //> res3: Double = 4.0
}