package lecture.part2oop

object Exceptions extends App {

  val x: String = null
  // println(x.length)
  // 1. throw exception
  // val aWeirdValue = throw new NullPointerException

  // throwable classes extend the throwable class
  // exception and error are the major throwable subtypes

  // 2. catch exception

  def getInt(withExceptions: Boolean): Int = {
    if (withExceptions) throw new RuntimeException("No int for you")
    else 43
  }

  val potentialFail = try {
    getInt(true)
  } catch {
    case e: RuntimeException => println("caught a Runtime exception")
  } finally {
    // optional
    // does not influence the return type of this expression
    // use finally only for side effects

    println("finally")
  }

  // 3. How to define your own exceptions
  class MyExceptions extends Exception

  val exception = new MyExceptions

  //throw exception
  /*
  1. Crash your program whit an OutOfMemoryError
  2. Crash with SOError
  3. PocketCalculator
    - add(x,y)
    - multiply(x,y)
    - divide(x,y)
    - subtract(x,y)

    Throw:
      - OverflowException if add(x,y) exceeds Int.Max
      - UnderflowException if subtract(x,y) exceeds Int.Min
      - MathCalculationException for division
   */
  // OOM
  // val array:Array[Int] = Array.ofDim(Int.MaxValue)
  // SO
  // def infinite: Int = 1 + infinite
  // val noLimit = infinite

  class OverFlowException extends RuntimeException
  class UnderFlowException extends RuntimeException
  class MathCalculationException extends RuntimeException("Division by 0")
  object PocketCalculator {
    def add(x: Int, y: Int):Int = {
      val result = x + y
      if(x > 0 && y > 0 && result < 0) throw new OverFlowException
      else if(x < 0 && y < 0 && result > 0) throw new UnderFlowException
      else result
    }
    def subtract(x: Int, y:Int): Int = {
      val result = x - y
      if(x > 0 && y < 0 && result < 0) throw new OverFlowException
      else if(x < 0 && y > 0 && result > 0) throw new UnderFlowException
      else result
    }
    def multiply(x: Int, y: Int): Int = {
      val result = x * y
      if(x > 0 && y > 0 && result < 0) throw new OverFlowException
      else if(x < 0 && y < 0 && result > 0) throw new OverFlowException
      else if(x < 0 && y > 0 && result > 0) throw new UnderFlowException
      else if(x > 0 && y < 0 && result > 0) throw new UnderFlowException
      else result
    }
    def divide(x: Int, y:Int): Int = {
      if(y == 0) throw new MathCalculationException
      else x / y
    }
  }
  // println(PocketCalculator.add(Int.MaxValue, 10))
  println(PocketCalculator.divide(10,0))
}
