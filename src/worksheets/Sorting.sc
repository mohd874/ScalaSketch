package worksheets

object Sorting {
  def quicksort(a: List[Int]): List[Int] = {
    if (a.length < 2)
      a
    else {
      val pivot = a(a.length / 2)
      quicksort(a.filter(_ < pivot)) :::
      a.filter(_ == pivot) :::
      quicksort(a.filter(_ > pivot))
    }
  }                                               //> sort: (a: List[Int])List[Int]
  
  val list = List(9, 5, 4, 7, 2, 6, 1)            //> list  : List[Int] = List(9, 5, 4, 7, 2, 6, 1)

  quicksort(list)                                 //> res0: List[Int] = List(1, 2, 4, 5, 6, 7, 9)
}