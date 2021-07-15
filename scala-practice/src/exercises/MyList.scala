package exercises

import lecture.part2oop.Generics.MyList

abstract class MyList[+A] {

  /*
    head = first element of the list
    tail = remainder of the list
    isEmpty = is this list empty
    add(int) => new list with this element added
    toString => a string representation of the list
   */
  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def add[B >:A ](element: B): MyList[B]
  def printElements: String

  override def toString: String = "[" + printElements + "]"

  def map[B](transformer: MyTransformer[A, B]): MyList[B]
  def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B]
  def filter(predicate: MyPredicate[A]): MyList[A]
  def ++[B >:A](list: MyList[B]): MyList[B]
}

object Empty extends MyList[Nothing] {
  def head: Nothing = throw new NoSuchElementException

  def tail: MyList[Nothing] = throw new NoSuchElementException

  def isEmpty: Boolean = true

  def add[B >: Nothing](element: B): MyList[B] = new Cons(element, Empty)

  def map[B](transformer: MyTransformer[Nothing, B]): MyList[B] = Empty
  def flatMap[B](transformer: MyTransformer[Nothing, MyList[B]]): MyList[B] = Empty
  def filter(predicate: MyPredicate[Nothing]): MyList[Nothing] = Empty
  def printElements: String = ""
  def ++ [B >: Nothing] (list: MyList[B]): MyList[B] = list
}
class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  def head: A = h

  def tail: MyList[A] = t

  def isEmpty: Boolean = false

  def add[B >: A](element: B): MyList[B] = new Cons(element, this)

  def printElements: String =
    if(t.isEmpty) "" + h
    else h + " " + t.printElements

  def filter(predicate: MyPredicate[A]): MyList[A] = {
    if(predicate.test(h)) new Cons(h, t.filter(predicate))
    else t.filter(predicate)
  }

  def map[B](transformer: MyTransformer[A, B]): MyList[B] = {
    new Cons(transformer.transform(h), t.map(transformer))
  }
  /*
  [1, 2] ++ [3,4,5]
  = new Cons(1, [2] ++ [3,4,5])
  = new Cons(1, new Cons(2, Empty ++ [3,4,5]))
  = new Cons(1, new Cons(2, [3,4,5]))
  = new Cons(1, new Cons(2, new Cons(3, new Cons(4, new Con(5, Empty)))))
   */
  def ++[B >:A](list: MyList[B]): MyList[B] = {
    new Cons(h, t ++ list)
  }

  /*
  [1, 2].flatMap(n => [n, n+1]
  = [1, 2] ++ [2].flatMap(n => [n, n+1])
  = [1, 2] ++ [2, 3] ++ Empty.flatMap(n => [n, n+1])
  = [1, 2] ++ [2, 3] ++ Empty
  = [1, 2, 2, 3]
   */
  def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B] = {
    transformer.transform(h) ++ t.flatMap(transformer)
  }
}
trait MyPredicate[-T] {
  def test(elem: T): Boolean
}

trait MyTransformer[-A, B] {
  def transform(elem: A): B
}
object ListTest extends App {
//  val list = new Cons(1, new Cons(2, new Cons(3, Empty)))
//  println(list.head)
//  println(list.add(4).head)
//
//  println(list.toString)
  val listOfInt: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, new Cons(4,Empty))))
  val anotherListOfInt: MyList[Int] = new Cons(5, new Cons(6, new Cons(7, new Cons(8,Empty))))
  val listOfString: MyList[String] = new Cons("one", new Cons("two", new Cons("three", Empty)))

  println(listOfInt.toString)
  println(listOfString.toString)

  println(listOfInt.map(new MyTransformer[Int, Int] {
    override def transform(elem: Int): Int = elem * 2
  }).toString)

  println(listOfInt.filter(new MyPredicate[Int] {
    def test(elem: Int): Boolean = elem  % 2 == 0
  }))

  println((listOfInt ++ anotherListOfInt).toString)

  println(listOfInt.flatMap(new MyTransformer[Int, MyList[Int]] {
    override def transform(elem: Int): MyList[Int] = new Cons(elem, new Cons(elem+1, Empty))
  }).toString)


}