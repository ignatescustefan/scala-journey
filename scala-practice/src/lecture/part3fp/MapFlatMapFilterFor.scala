package lecture.part3fp

object MapFlatMapFilterFor extends App {

  val list = List(1, 2, 3, 4)
  println(list)
  println(list.head)
  println(list.tail)

  // map
  println(list.map(_ + 1))
  println(list.map(_ + " is an number"))

  // filter
  println(list.filter(_ % 2 == 0))

  //flatMap
  val toPair = (x: Int) => List(x, x + 1)
  println(list.flatMap(toPair))

  // print all combination between two list
  val numbers = List(1, 2, 3)
  val chars = List('a', 'b', 'c', 'd')
  val colors = List("Black", "White")
  // List("a1","a2",.."d4")
  //  private def function = {
  //    n:Int => chars.map(c => "" + c + n)
  //  }

  // "iteration"
  val combination = numbers.flatMap(n => chars.map(c => "" + c + n))
  val newCombination = numbers.flatMap(n => chars.flatMap(c => colors.map(color => "" + color + "-" + c + "-" + n)))

  println(combination)
  println(newCombination)

  list.foreach(println)

  // for-comprehensions
  val forComprehensions = for {
    n <- numbers if n % 2 == 0
    c <- colors
    color <- colors
  } yield "" + c + n + "-" + color
  println(forComprehensions)

  for {
    n <- numbers
  } println(n)

  // syntax overload
  list.map { x =>
    x * 2
  }

  /*
  1. MyList supports for comprehensions?
    - map(f: A => B) => MyList[B]
    - filter(p: A => Boolean) => MyList[A]
    - flatMap(f: A => MyList[B]) => MyList[B]
  2. A small collection of at most one element - Maybe[+T]
    - map, flatMap, filter
   */
}
