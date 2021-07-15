package lecture.part3fp

object WhatsAFunction extends App {

  // Dream: use functions as first class elements
  // Problem: oop

  val doubler = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }
  println(doubler(2))

  // function types = Function[A, B]
  val stringToIntConverter = new Function1[String, Int] {
    override def apply(v1: String): Int = v1.toInt
  }

  println(stringToIntConverter("3")  + 4)

  val adder:((Int, Int) => Int) = new Function2[Int, Int, Int] {
    override def apply(a:Int, b:Int):Int = a + b
  }

  // Function types Function2[A, B, R] === (A, B)=>R
  // All scala functions are objects

  /*
  1. a function which takes 2 string and concatenates them
  2. transform the MyPredicate and MyTransformer into function types
  3. define a function which takes an Int and return another function which takes an int and returns an int
      - what's the type of this function
      - how to do it
   */

  def concatenator: (String, String) => String = new Function2[String, String, String] {
    override def apply(v1: String, v2: String): String = v1 + v2
  }

  // Function1[Int, Function1[Int,Int]]

  val superAdder: Function1[Int, Function1[Int,Int]]= new Function1[Int, Function1[Int,Int]] {
    override def apply(x: Int): Function1[Int, Int] = new Function1[Int,Int] {
      override def apply(y: Int): Int = x + y
    }
  }

  val adder3 = superAdder(3)
  println(adder3(4) + " " + superAdder(3)(6)) // curried function

  println(concatenator("Hello, ", "Scala"))
  trait MyFunction[A,B] {
    def apply(element: A): B = ???
  }
}
