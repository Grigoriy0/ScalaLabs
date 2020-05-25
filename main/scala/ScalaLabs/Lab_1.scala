package ScalaLabs


import scala.annotation.tailrec
// 15. Заменить все строчные буквы на прописные.

object Lab_1 {

  def run(): Unit = {
    val str : String = " hgwauek ghu HUKHGR Uk IUKH KEF huukFuk FH FKUh UFKh fkuH UWKFEHUWefhuw gU hfkuFKHKFUFEkfus"

    println(str)
//    println(str.toUpperCase())
    val list = List[Int](1, 2, 3)

    println(String.valueOf(toUpper(str.toCharArray)))
    println(String.valueOf(toUpperR(str.toCharArray, 0)))
  }

  private def toUpper(chars: Array[Char]): Array[Char] =
    chars.map(_.toUpper)

  private def sToUpper(string: String): String =
    string.toUpperCase()

  @tailrec
  private def toUpperR(chars: Array[Char], i: Int): Array[Char] = {
    chars(i) = chars(i).toUpper
    if (i == chars.length - 1)
      chars
    else
      toUpperR(chars, i + 1)
  }

}