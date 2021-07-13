package lecture.part1basics

import scala.annotation.tailrec

object Recursion extends App {
  //@tailrec
  def factorial(n: Int): Int = {
    if (n <= 1) 1
    else {
      println("Computing factorial of " + n + " - I need factorial of " + (n-1))
      val result = n * factorial(n-1)
      println("Computed factorial of " + n)
      result
    }
  }
  println(factorial(7))

  def anotherFactorial(n: Int): Int = {
    @tailrec
    def factHelper(x: Int, accumulator: Int): Int = {
      if (x <= 1) accumulator
      else factHelper(x - 1, x * accumulator) // Tail recursion = use recursive call as the LAST expresion
    }
    factHelper(n, 1)
  }

}
