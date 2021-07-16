package lecture.part3fp

import org.jcp.xml.dsig.internal.dom.DOMX509Data

object HOFsCurries extends App {

  val superFunction: (Int, (String, (Int => Boolean)) => Int) => (Int => Int) = null
  // higher order function (HOF)


  // map flatMap, filter in MyList

  // function that applies a function n times over a value x
  // nTimes(f, n, x)
  // nTimes(f, 3, x) = f(f(f(x))) = nTimes(f, 2, f(x))
  def nTimes(f: Int => Int, n: Int, x: Int): Int = {
    if (n <= 0) x
    else nTimes(f, n - 1, f(x))
  }

  val plusOne = (x: Int) => x + 1
  println(nTimes(plusOne, 10, 1))

  // ntb(f,n) = x => f(f(f..(x)))
  // incremet10 = ntb(plusOne,10) = x => plusOne(plusOne...(x))
  // val y = increment10(1)
  def nTimesBetter(f: Int => Int, n: Int): (Int => Int) =
    if (n <= 0) (x: Int) => x
    else (x: Int) => nTimesBetter(f, n - 1)(f(x))

  val plus10 = nTimesBetter(plusOne, 10)
  println(plus10(1))
  // curried functions
  val superAdder: Int => (Int => Int) = (x: Int) => (y: Int) => x + y
  val add3 = superAdder(3)
  println(add3(10))
  println(superAdder(3)(9))

  // functions with multiple parameter lists
  def curriedFormatter(c: String)(x: Double) = c.format(x)

  val standardFormat: (Double => String) = curriedFormatter("%4.2f")

  val preciseFormat: (Double => String) = curriedFormatter("%10.8f")

  println(standardFormat(Math.PI))
  println(preciseFormat(Math.PI))

  /*
  1. Expand MyList
   - foreach method A => Unit
    [1,2,3].foreach(x => println)

   - sort function ((A,A) => Int) => MyList
    [1,2,3].sort((x,y) => y-x) => [3,2,1]

   - zipWith (list, (A, A) => B) => MyList[B]
    [1,2,3].zipWith([4,5,6], x*y) => [4,10,18]

   - fold(start)(function) => a value
    [1,2,3].fold(0)(x+y) = 6

   2. toCurry(f: (Int,Int) => Int) => (Int => Int => Int)
      fromCurry(Int => Int => Int) => (f: (Int,Int) => Int)
  */
  def toCurry(f: (Int, Int) => Int): (Int => Int => Int) =
    x => y => f(x, y)

  def fromCurry(f: (Int => Int => Int)): (Int, Int) => Int =
    (x, y) => f(x)(y)
  /*
   3. compose(f,g) => x => f(g(x))
      andThen(f,g) => x => g(f(x))
   */

  //FunctionX
  val f = new Function[Int, Int] {
    def apply(v1: Int): Int = v1
  }

  def compose[A, B, T](f: A => B, g: T => A): T => B =
    x => f(g(x))

  def andThen[A, B, C](f: A => B, g: B => C): A => C =
    x => g(f(x))

  def superAdder2: (Int => Int => Int) = toCurry(_ + _)

  def add4 = superAdder2(4)

  println(add4(17))

  def simpleAdder = fromCurry(superAdder2)

  println(simpleAdder(4, 17))

  val add2 = (x: Int) => x + 2
  val times = (x: Int) => x * 3
  val composed = compose(add2, times)
  val ordered = andThen(add2, times)

  // composed(4) = add2(times(4)) = add2(12) = 14
  println(composed(4))
  // ordered(4) = times(add2(4)) = times(6) = 18
  println(ordered(4))
}