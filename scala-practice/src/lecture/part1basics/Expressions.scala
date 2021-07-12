package lecture.part1basics

object Expressions extends App {
  val x = 1 + 2 //expresion
  println(x)

  println(1 + 4 * 3)
  // + - * / | & ^ >> <<
  // >>> right shift with zero extension
  println(1 == x)
  // == != > < >= <=

  println(!(1 == x))
  // ! && ||
  var aVariable = 2
  aVariable+=3 // -= *= /=
  println(aVariable)
  // Instruction (DO) vs Expressions (VALUE)
  // if expression
  val aCondition = true
  val aConditionedValue = if(aCondition) 5 else 3
  println(aConditionedValue)

  var i = 0
  val aWhiele = while(i <= 10) {
    println(i)
    i+=1
  }

  val aWeirdValue = (aVariable = 3) // Unit -> void
  println(aWeirdValue)
  // side effects: printn, while reassigning
  // Code blocks
  val aCodeBlock = {
    val y = 2
    val z = y + 1
    if (z > 2) "hello" else "goodbye"
  }
  //value of a block it's the type of the last expression

  val someValue = {
    2 < 3
  }
  val someOtherValue = {
    if (someValue) 23 else 32
    43
  }
}
