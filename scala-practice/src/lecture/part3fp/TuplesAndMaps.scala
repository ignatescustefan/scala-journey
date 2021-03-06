package lecture.part3fp

import java.net.NetworkInterface
import scala.annotation.tailrec


object TuplesAndMaps extends App {

  // tuples = finite ordered "lists"

  val aTuple = Tuple2(2, "Hello, there") // Tuple2[Int, String] = (Int, String)

  println(aTuple._1) // 2
  println(aTuple.copy(_2 = "bye bye"))
  println(aTuple.swap)

  // maps - keys -> values
  val aMap: Map[String, Int] = Map()
  val phonebook = Map(("Jim", 555), "Daniel" -> 789, "JIM" -> 990).withDefaultValue(-1)
  // a->b is sugar for (a,b)
  println(phonebook)

  println(phonebook.contains("Jim"))
  println(phonebook("Marry"))

  // add a pairing
  val newPairing = "Mary" -> 678
  val newPhoneBook = phonebook + newPairing
  println(newPhoneBook)

  // function on maps
  // map, flatMap, filter

  println(phonebook.map(pair => pair._1.toLowerCase -> pair._2))
  // println(phonebook.filterKeys(x => x.startsWith("J")).toString())
  println(phonebook.view.filterKeys(x => x.startsWith("J")).mkString(" "))
  // mapValues
  // println(phonebook.mapValues(number => number * 10).mkString(" "))
  println(phonebook.view.mapValues(number => "07431" + number * 10).mkString(" "))

  // conversion to other collections
  println(phonebook.toList)
  println(List(("Daniel", 555)).toMap)

  val names = List("Bob", "James", "Angela", "Mary", "Daniel", "Jim")
  println(names.groupBy(name => name.charAt(0)))
  /*
  1. What would happen if I had two original entries "Jim" -> 555 and "JIM" -> 990?
    - careful with mapping key
  2. Overly simplified social network based in maps
    Person = String
    - add a person to the network
    - remove
    - friend (mutual)
    - unfriend

    - number of friends of a person
    - person with most friends
    - how many people have NO friends
    - if there is a social connection between two people (direct or no)
   */

  def add(network: Map[String, Set[String]], person: String): Map[String, Set[String]] = {
    network + (person -> Set())
  }

  def friend(network: Map[String, Set[String]], a: String, b: String): Map[String, Set[String]] = {
    val friendsA = network(a)
    val friendsB = network(b)

    network + (a -> (friendsA + b)) + (b -> (friendsB + a))
  }

  def unfriend(network: Map[String, Set[String]], a: String, b: String): Map[String, Set[String]] = {
    val friendsA = network(a)
    val friendsB = network(b)

    network + (a -> (friendsA - b)) + (b -> (friendsB - a))
  }

  def remove(network: Map[String, Set[String]], person: String): Map[String, Set[String]] = {
    def removeAux(friends: Set[String], networkAcc: Map[String, Set[String]]): Map[String, Set[String]] =
      if (friends.isEmpty) networkAcc
      else removeAux(friends.tail, unfriend(networkAcc, person, friends.head))

    val unfriended = removeAux(network(person), network)
    unfriended - person
  }

  val empty: Map[String, Set[String]] = Map()
  val network = add(add(empty, "Bob"), "Mary")
  println(network)
  println(friend(network, "Bob", "Mary"))
  println(unfriend(friend(network, "Bob", "Mary"), "Bob", "Mary"))
  println(remove(friend(network, "Bob", "Mary"), "Bob"))

  val people = add(add(add(empty, "Bob"), "Mary"), "Jim")
  val jimBob = friend(people, "Bob", "Jim")
  val testNet = friend(jimBob, "Bob", "Mary")

  println(testNet)

  def nFriends(network: Map[String, Set[String]], person: String): Int =
    if (!network.contains(person)) 0
    else network(person).size

  println(nFriends(testNet, "Bob"))

  def mostFriend(network: Map[String, Set[String]]): String =
    network.maxBy(pair => pair._2.size)._1

  println(mostFriend(testNet))

  def nPeopleWithNoFriends(network: Map[String, Set[String]]) = {
    // network.view.filterKeys(k => network(k).isEmpty)
    // network.view.filter(pair => pair._2.isEmpty)
    // network.count(pair => pair._2.isEmpty)
    network.count(_._2.isEmpty)
  }

  println(nPeopleWithNoFriends(testNet))

  def socialConnection(network: Map[String, Set[String]], a: String, b: String): Boolean = {
    @tailrec
    def bfs(target: String, consideredPeople: Set[String], discoveredPeople: Set[String]): Boolean = {
      if (discoveredPeople.isEmpty) false
      else {
        val person = discoveredPeople.head
        if (person == target) true
        else if (consideredPeople.contains(person)) bfs(target, consideredPeople, discoveredPeople.tail)
        else bfs(target, consideredPeople + person, discoveredPeople.tail ++ network(person))
      }
    }

    bfs(b, Set(), network(a) + a)
  }

  println(socialConnection(testNet, "Mary", "Jim"))
  println(socialConnection(network, "Mary", "Bob"))

}
