package lecture.part1basics

object StringOps extends App {

  val str: String = "Hello, hello"
  println(str.charAt(2))
  println(str.substring(4, 10))
  println(str.split(" ").toList)
  println(str.startsWith("Hello"))
  println(str.replace("l","*"))
  println(str.toLowerCase())
  println(str.length)
  val aNumberString = "45"
  val aNumber = aNumberString.toInt
  println('a' +: aNumberString :+ 'z')
  println(str.reverse)
  println(str.take(2))
  val name = "David"
  val age = 12
  // S-interpolators
  val greeting = s"Hello, my name is $name and I am $age years old"
  val anotherGreeting = s"Hello, my name is $name and I am ${age + 1} years old"
  println(anotherGreeting)

  val speed: Float = 1.2f
  // F-interpolators
  val myth = f"$name%s can eat $speed%2.2f burgers per minute"
  println(myth)

  // raw-interpolator
  println(raw"This is a \n newline")
  val escaped = "This is a \n newline"
  println(raw"$escaped")


}
