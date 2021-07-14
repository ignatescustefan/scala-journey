package lecture.part2oop

object Object {

  // Scala does not have class-level functionality ("static")
  object Person { // type + its only instance
    // "static"/"class" - level functionality
    val N_EYES = 2

    def canFly: Boolean = false

    def from(mother: Person, father: Person): Person = new Person("Bobbie")

    def apply(mother: Person, father: Person): Person = new Person("Bobbie")

  }

  class Person(val name: String) {
    //instance-level functionality
  }
  // Companions same scope&name

  def main(args: Array[String]): Unit = {
    println(Person.N_EYES)
    println(Person.canFly)


    // Scala object = singleton instance
    val mary = new Person("Mary")
    val john = new Person("John")
    println(mary == john)

    val person1 = Person
    val person2 = Person

    println(person2 == person1)

    // val bobbie = Person.from(mary, john)
    // val bobbie1 = Person.apply(mary, john)
    val bobbie2 = Person(mary, john)

    // Scala Applications = Scala object with
    // def main(args: Array[String]): Unit
  }
}
