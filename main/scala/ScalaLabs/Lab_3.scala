package ScalaLabs

//15. Добавить бит чётности после каждых 8 бит.

import scala.io.StdIn.readLine

object Lab_3 {
  def run(): Unit = {
    println("Enter string to encode: ")
    val input = readLine
    var data = input
    println("Encoded string:")
    data = encode(data);
    println(data)
    println("Decoded string:")
    println(decode(data))
  }

  def encode(original: String): String = {
    var second = '0'
    var result: String = ""
    var index = 0
    do {
      result += original.substring(index, index + 8)
      result += second
      index += 8
      if (second == '1')
        second = '0'
      else
        second = '1'
    } while(index < original.length);
    result
  }

  def decode(encoded: String): String = {
    var index: Int = 0
    var controlBit: Char = '0'
    var result: String = ""
    while (index < encoded.length) {
      result += encoded.substring(index, index + 8)
      if (encoded(index + 8) != controlBit)
        throw new RuntimeException("Data corrupted")
      if (controlBit == '1')
        controlBit = '0'
      else controlBit = '1'
      index += 9
    }
    result
  }
}