package lecture.part2oop

object OOBasics extends App {
  val person = new Person("David", 32)
  println(person.x)
  person.greet("Daniel")
  person.greet()
}
// constructor
class Person(name: String,val age: Int = 0) {
  // body
  val x = 2

  println(1+2)

  // method
  def greet(name: String): Unit = println(s"${this.name} says: Hi , $name")
  // overloading
  def greet(): Unit = println(s"Hi, I am $name")
  // multiple constructors
  def this(name: String) = this(name, 0)
  def this() = this("John Doe")
}

// class parameters are not fields!!