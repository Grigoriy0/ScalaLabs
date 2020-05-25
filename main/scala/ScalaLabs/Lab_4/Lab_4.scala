package ScalaLabs.Lab_4

import java.math.BigInteger

//15.	Банк. Необходимо реализовать:
// создание нового клиента, содержащего имя, номер счёта и сумму денег;
// снятие денег со счёта;
// добавление денег на счёт.

object Lab_4 {
  def run(): Unit = {
    val account = new BankAccount(5, "jenny", 56)
    account.sum_+=(56)
    println(s"User #${account.id} ${account.name} has ${account.sum} money")
    try {
      account.sum_-=(new BigInteger("99999999999999"))
    }catch {
      case rt: RuntimeException => println(rt.getMessage)
    }
  }
}