package lecture.part1basics

object ValuesVariablesTypes extends App {
  //type of vals are optional
  val x:Int = 42
  // val x = 42
  println(x)

  // vals are immutable !!!
  //  x=2 ERR
  // Compliler can infer types

  val aString: String = "Hello";

  val aBoolean: Boolean = true //false
  val aChar: Char = 'a'
  val anInt: Int = x
  val aShort: Short = 32143
  val aLong: Long = 3412314333333L
  val aFloat: Float = 2.0F
  val aDouble: Double = 2.321

  //variables

  var aVariable: Int = 4
  aVariable = 5 // side effects
}
