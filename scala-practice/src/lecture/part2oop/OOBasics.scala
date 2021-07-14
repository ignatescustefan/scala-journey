package lecture.part2oop

object OOBasics extends App {
  val person = new Person("David", 32)
  println(person.x)
  person.greet("Daniel")
  person.greet()

  val author = new Writer("Charles", "Dickens", 1812)
  val imporster = new Writer("Charles", "Dickens", 1812)
  val novel = new Novel("Great Expectations", 1861, author)

  println(novel.authorAge)
  println(novel.isWrittenBy(author))
  println(novel.isWrittenBy(imporster))

  val counter:Counter = new Counter

  counter.inc.print
  counter.inc.inc.inc.print
  counter.inc(10).print
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

/*
Novel and a Writer
Writer: frist name, surname, year
  - method fullname

*/
class Writer(firstName: String, lastName: String, val year: Int) {
  def fullName: String = firstName + " " + lastName
}
/*
Novel: name, year of release, author
  - authorAge
  - isWrittenBy(author)
  - copy (new year of release) = new instance of Novel
*/
class Novel(name: String, year: Int, author: Writer) {
  def authorAge: Int = year - author.year
  def isWrittenBy(author: Writer): Boolean = author == this.author
  def copy(newYear: Int): Novel = new Novel(name, newYear, author)
}
/*
Counter class
  - receives an int value
  - method current count
  - method to increment/decrement => new Counter
  - overload inc/dec to receive an amount

 */
class Counter(val counter: Int = 0) {
  def inc = {
    println("incrementing")
    new Counter(counter + 1)
  } // immutability
  def dec = {
    println("decrementing")
    new Counter(counter - 1)
  }

//  def inc(amount: Int): Counter = new Counter(counter + amount)
//  def dec(amount: Int): Counter = new Counter(counter - amount)

  def inc(n: Int):Counter = {
    if(n <= 0) this
    else inc.inc(n-1)
  }
  def dec(n: Int):Counter = {
    if(n <= 0) this
    else dec.dec(n-1)
  }
  def print = println(counter)
}