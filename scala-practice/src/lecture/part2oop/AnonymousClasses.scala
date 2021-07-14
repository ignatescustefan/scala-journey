package lecture.part2oop

object AnonymousClasses extends App {

  abstract class Animal {
    def eat: Unit
  }

  // anounymous class
  //  val funnyAnimal: Animal = new Animal {
  //    override def eat: Unit = println("hahahaha")
  //  }
  //equivalent ->
  class AnonymousClasses$$anon$1 extends Animal {
    override def eat: Unit = println("hahahah")
  }

  //println(funnyAnimal.getClass)

  class Person(name: String) {
    def sayHi: Unit = println(s"Hi, my name is $name, how can I help")
  }
  def jim = new Person("Jim") {
    override def sayHi: Unit = println(s"Hi, my name is Jim, how can I be of service")
  }
}