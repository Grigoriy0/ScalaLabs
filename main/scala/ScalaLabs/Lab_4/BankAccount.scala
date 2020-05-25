package ScalaLabs.Lab_4



class BankAccount(val id: Int, val name: String, private var _sum: BigInt = 0) {
  def sum: BigInt ={
    val s = _sum
    s
  }

  def sum_+=(sum: BigInt): Unit ={
    _sum += sum
  }

  def sum_-=(sum: BigInt): Unit ={
    if (sum > _sum)
      throw new RuntimeException(s"account has only ${_sum}, not ${sum}")
    _sum -= sum
  }
}
