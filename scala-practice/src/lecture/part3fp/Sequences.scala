package lecture.part3fp

import scala.::
import scala.collection.View.Collect
import scala.util.Random

object Sequences extends App {
  // Seq

  val aSequence = Seq(1, 2, 0, 4)
  println(aSequence)
  println(aSequence.reverse)
  println(aSequence(2))
  println(aSequence ++ Seq(9, 6, 7))
  println(aSequence.sorted)

  // Ranges
  val aRange: Seq[Int] = 1 until 10 // until vs to
  aRange.foreach(println)
  (1 to 10).foreach(x => println("hello"))

  // Lists

  val aList = List(1, 2, 3)
  val prepended = 42 :: aList
  val prepended1 = 43 +: aList :+ 89
  println(prepended)
  println(prepended1)

  val apples5 = List.fill(5)("apple")

  println(apples5)
  println(aList.mkString("-|-"))

  // Arrays
  val numbers = Array(1, 2, 3, 4)
  val threeElements = Array.ofDim[String](3)
  threeElements.foreach(println)
  // mutation
  numbers(2) = 0 // syntax sugar for number.update(2, 0)
  println(numbers.mkString(" "))

  // array and seq
  val numbersSeq: Seq[Int] = numbers // implicit conversion
  println(numbersSeq)

  // Vectors

  val vector: Vector[Int] = Vector(1, 2, 3)
  println(vector)

  val maxRuns = 1000
  val maxCapacity = 1000000

  def getWriteTime(collection: Seq[Int]): Double = {
    val r = Random
    val times = for {
      _ <- 1 to maxRuns
    } yield {
      val currentTime = System.nanoTime()
      collection.updated(r.nextInt(maxCapacity), r.nextInt())
      System.nanoTime() - currentTime
    }
    times.sum * 1.0 / maxRuns
  }

  val numbersList = (1 to maxCapacity).toList
  val numbersVector = (1 to maxCapacity).toVector

  // keeps reference to tail
  // updating an element in the middle takes long
  println(getWriteTime(numbersList))

  // depth of the tree is small
  // needs to replace an entire 32 element chunk
  println(getWriteTime(numbersVector))
}
