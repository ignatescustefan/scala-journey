package lecture.part2oop

object Inheritance extends App {

  // final
  sealed class Animal {
    val creatureType = "Wild"
    //final
    def eat = println("yummy")
  }

  class Cat extends Animal {
    def crunch = {
      eat
      println("crunch crunch")
    }
  }
  val cat = new Cat
  cat.crunch

  // constructors
  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }

  class Adult(name: String, age: Int, idCard: String) extends Person(name)

  //overriding
  class Dog(override val creatureType: String) extends Animal {
    // override val creatureType: String = "domestic"
    override def eat = {
      super.eat
      println("crunch dog")
    }
  }
  // is like
//  class Dog(val dogType: String) extends Animal {
//    override val creatureType: String = dogType
//    override def eat = println("crunch dog")
//  }
  val dog = new Dog("K9")
  dog.eat
  println(dog.creatureType)

  // type substitution (broad: polymorphism)
  val unknownAnimal: Animal = new Dog("k9")
  unknownAnimal.eat

  // overriding vs overloading

  // super -> parent class

  // preventing for overrides
  // 1 - use final on member
  // 2 - use final on the class
  // 3 - seal the class = extend classes in this file, prevent extension in other files
}
