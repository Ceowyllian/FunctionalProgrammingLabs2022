package skillonomy.traits

import skillonomy.exceptions.NotEnoughMoneyException

import java.util

trait Student extends PlatformUser {
  protected val _teachers: util.HashMap[Coach, Double] = new util.HashMap()

  def teachers: util.HashMap[Coach, Double] = _teachers

  def addCoach(coach: Coach, tuitionFee: Double): Unit =
    _teachers.put(coach, tuitionFee)

  def payTuitionFee(): Unit =
    _teachers
      .keySet()
      .forEach(coach => {
        val amount = _teachers.get(coach)
        tryPayMoney(coach, amount)
      })

  def tryPayMoney(coach: Coach, amount: Double): Unit =
    try
      transferMoney(coach, amount)
    catch
      case e: NotEnoughMoneyException =>
        val tokens = moneyToTokens(e.lacks)
        sellTokens(tokens)
        tryPayMoney(coach, amount)

}
