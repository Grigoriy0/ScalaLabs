package ScalaLabs

import ScalaLabs.Lab_4.Lab_4

object Main {
  def main(args: Array[String]): Unit = {
    if (args.isEmpty)
      return
    val index: Int = args(0).toInt
    index match {
      case 1 => Lab_1.run()
      case 2 => Lab_2.run()
      case 3 => Lab_3.run()
      case 4 => Lab_4.run()
      case 5 => println(s"wrong argument ${args(0)}")
    }
  }
}