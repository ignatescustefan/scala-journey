package lecture.part2oop

object AbstractDataTypes extends App {

  // abstract
  abstract class Animal {
    val creatureType: String = "Wild"
    def eat: Unit
  }
  class Dog extends Animal {
    override val creatureType: String = "canine"

    def eat: Unit = println("crunch crunch")
  }

  // traits
  trait Carnivore {
    def eat(animal: Animal): Unit
    val preferredMeal: String = "fresh meat"
  }
  trait ColdBlooded

  class Crocodile extends Animal with Carnivore with ColdBlooded {
    override val creatureType: String = "croc"

    def eat: Unit = println("yummy")

    def eat(animal: Animal): Unit = println(s"I'm a croc and I'm eating ${animal.creatureType}")
  }

  val dog = new Dog
  val croc = new Crocodile
  croc.eat(dog)
  /*
  traits vs abstract classes
  1 - traits do not have constructors parameters
  2 - multiple traits may be inherited by the same class
  3 - traits = behavior, abstract class = "thing"
   */

  /*
  scala.Any
    - scala.AnyVal (Int, Boolean etc )                    ->}
                                                              => scala.Nothing
    - scala.AnyRef (String, List, Set ...) -> scala.Null  ->}
   */
}
