package lecture.part2oop

import playground.{PrinceCharming, Cinderella => Princess}

import java.sql
import java.util.Date
import java.sql.{Date => SqlDate}
object PackagingAndImports extends App {
  // package memers are accessible by their simple name
  val writer = new Writer("Daniel", "RockTheJVM",2019)

  // import the package
  val princess = new Princess //playground.Cinderella

  // packages are in hierarchy
  // matching folder structure

  // package object
  sayHello
  println(SPEED_OF_LIGHT)

  // imports
  val prince = new PrinceCharming

  // 1. use FQ names
  val date = new Date
  val sqlDate = new SqlDate(2017,8,4)

  // default imports
  // java.lang - String, Object
  // scala - Int, Nothing, Function
  // scala.Predef - println, ???

}
