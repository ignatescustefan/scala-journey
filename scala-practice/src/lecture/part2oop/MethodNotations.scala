package lecture.part2oop

import scala.language.postfixOps

object MethodNotations extends App {

  class Person(val name: String, favoriteMovie: String) {
    def likes(movie: String): Boolean = movie == favoriteMovie
    def hangOutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def + (person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def unary_! : String = s"$name, smth"
    def isAlive: Boolean = true
    def apply(): String = s"Hi, my name is $name, and I like $favoriteMovie"
  }
  val mary = new Person("Mary","Inception")

  println(mary.likes("Inception"))
  println(mary likes "Inception")
  // infix notation = operator notation
  // "operators" in Scala
  val tom = new Person("Tom", "Fight Club")
  println(mary hangOutWith tom)
  println(mary + tom)

  println(1 + 2)
  println(1.+(2))
  // All operators are methods
  // Akka actors have ! ?

  // prefix notation
  val x = -1 // == 1.unary_-
  val y = 1.unary_-
  // unary_ prefix only works with - + ~ !

  println(!mary)
  println(mary.unary_!)

  // postfix

  println(mary.isAlive)
  println(mary isAlive) // methods without parameters

  // apply

  println(mary.apply())
  println(mary()) // equivalent

}
