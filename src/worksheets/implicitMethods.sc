package worksheets

object implicitMethods {
  class Num(val value: Int){
  	def negate = new Num(value * -1)
  	override def toString = value.toString
  }
  
  val i = new Num(3)                              //> i  : worksheets.implicitMethods.Num = 3
  i.negate                                        //> res0: worksheets.implicitMethods.Num = -3
  
  implicit def int2Number (i: Int) = new Num(i)   //> int2Number: (i: Int)worksheets.implicitMethods.Num
  implicit def number2Int (i: Num) = i.value      //> number2Int: (i: worksheets.implicitMethods.Num)Int
   
  val n = 5                                       //> n  : Int = 5
  val d = new Num(3)                              //> d  : worksheets.implicitMethods.Num = 3
  
  n*d                                             //> res1: Int = 15
  
  d*n                                             //> res2: Int = 15
}