package lecture.part3fp

object TuplesAndMaps extends App {

  // tuples = finite ordered "lists"

  val aTuple = Tuple2(2, "Hello, there") // Tuple2[Int, String] = (Int, String)

  println(aTuple._1) // 2
  println(aTuple.copy(_2 = "bye bye"))
  println(aTuple.swap)

  // maps - keys -> values
  val aMap: Map[String, Int] = Map()
  val phonebook = Map(("Jim", 555), "Daniel" -> 789).withDefaultValue(-1)
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
  
}
