package ScalaLabs
// 15. Подсчитать количество совпадающих символов, стоящих на одинаковых позициях
// относительно первого элемента, в двух коллекциях.

import scala.io.StdIn.readLine

object Lab_2 {
  object count
  def run(): Unit = {
    println("Enter first line:")
    val str_1 = readLine.toList
    println("Enter second line:")
    val str_2 = readLine.toList
    println(s"Count of matching characters:\n ${
      count(str_1, str_2, filter = compare, functor = inc)
    }")
  }

  private def inc(count: Int): Int = count + 1

  private def compare = (ch1: Char, ch2: Char) => ch1.equals(ch2)

  private def count(string1: List[Char], string2: List[Char],
                    filter: (Char, Char) => Boolean,
                    functor: Int => Int): Int ={
    var result: Int = 0
    try{
      for (i <- string1.indices)
        if (filter(string1(i), string2(i)))
          result = functor(result)
      result
    }catch{
      case _: IndexOutOfBoundsException => result
    }
  }
}
