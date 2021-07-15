package lecture.part3fp

object AnonymousFunctions extends App {

  val doubler1 = new Function[Int, Int] {
    override def apply(x: Int ): Int = x * 2
  }
  // anonymous function lambda
  val doubler: Int => Int = x => x * 2
  // multiple params in a lambda
  val adder = (a:Int, b: Int) => a + b
  val adder1: (Int, Int) => Int = (a:Int, b:Int) => a + b

  //no params
  val justDoSomething:() => Int = () => 3

  // careful
  println(justDoSomething) // function
  println(justDoSomething()) // call

  // curly braces with lambda

  val stringToInt = { (str: String) =>
    str.toInt
  }

  val niceIncrementer1: Int => Int = (x: Int) => x + 1
  val niceIncrementer: Int => Int = _ + 1
  val niceAdder1: (Int, Int) => Int = (x:Int, y:Int) => x + y
  val niceAdder:(Int, Int) => Int = _ + _ // equivalent to (a,b) => a + b

  /*
  1. MyList: replace all FunctionX calls with lambdas
  2. Define/Rewrite the "special" adder as an anonymous functions
   */

  val superAdd = (x: Int) => (y: Int) => x + y
  println(superAdd(2)(4))
}
