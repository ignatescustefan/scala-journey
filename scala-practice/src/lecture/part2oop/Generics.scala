package lecture.part2oop

object Generics extends App {

  // generic type
  class MyList[+A] {
    def add[B >: A](element: B): MyList[B] = ???
    // use the type A

  }

  val listOfInt = new MyList[Int]
  val listOfString = new MyList[String]

  class MyMap[Key, Value]

  // generic methods

  object MyList {
    def empty[A]: MyList[A] = ???

  }

  val emptyListOfInt = MyList.empty[Int]

  // variance problem

  class Animal

  class Cat extends Animal

  class Dog extends Animal

  // 1 - yes List[Cat] extends List[Animal] = covariance

  class CovariantList[+A]

  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  // animalList.add(new Dog) ??? hard question => we return a list of animals

  // 2 - No = invariante

  class InvariantList[A]

  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]

  // 3 - Hell, no! Contravariance
  class ContravariantList[-A]
  val contravariantList: ContravariantList[Cat] = new ContravariantList[Animal]

  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]

  // bounded types
  class Cage[A <: Animal](animal: Animal) // only subtype of animal
  val cage = new Cage(new Dog)

  class Car
  // val newCage = new Cage(new Car) //error
  // expand MyList to generic
}


