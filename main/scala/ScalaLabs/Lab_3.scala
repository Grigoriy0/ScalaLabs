package ScalaLabs

//15. Добавить бит чётности после каждых 8 бит.

import scala.io.StdIn.readLine

object Lab_3 {
  def run(): Unit = {
    println("Enter string to encode: ")
    val input = readLine

    var data = toBitString(input)
    println("You enter:      " + data)
    var flag: Boolean = false
    var repeatCount: Int = 0
    do {
      flag = false
      data = encode(data)
      println("Encoded string: " + data)
      try {
        data = decode(data)
      }catch {
        case _: Throwable => println("Repeat input")
          repeatCount += 1;
          flag = true
      }
      println("Decoded string: " + data)
    } while(flag == true && repeatCount < 10)
    if (flag == true) {
      println("Happened error while decoding your information")
    }
  }

  def toBitString(string: String): String = {
    var result: String = ""
    for (index <- string.indices) {
      var char: String = string(index).toBinaryString
      while (char.length < 8) {
        char = char.patch(0, "0", 0)
      }
      result += char
    }
    result
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
    } while(index < original.length)
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