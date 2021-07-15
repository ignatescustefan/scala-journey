package lecture.part2oop

object CaseClasses extends App {

  /*
  equals, hashCode, toString
   */
  case class Person(name: String, age:Int)

  // 1. class parameters are fields
  val jim = new Person("Jim", 34)
  println(jim.name)

  // 2. sensible toString
  println(jim) // syntactic sugar
  println(jim.toString)

  // 3. equals && hashCode implemented OOTB

  val jim2 = new Person("Jim", 34)
  println(jim == jim2)

  // 4. CaseClasses handy copy method
  val jim3 = jim.copy(age = 44)
  println(jim3)
  // 5. CaseClasses have companion Objects
  val thePerson = Person
  val mary = Person("Mary", 23) // apply method

  // 6. CaseClasses are serializable
  // Akka  framework

  // 7. CaseClasses have extractor pattern = CaseClasses can be used in Patter Matching

  case object UnitedKingdom {
    def name: String = "The UK of GB and NI"
  }
  /*
  Expend MyList - use case classes & object
   */
}
