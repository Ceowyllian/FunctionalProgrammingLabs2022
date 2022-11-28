package skillonomy.traits

import skillonomy.exceptions.*

/** `PlatformUser` is a trait that represents interaction with the
 * "Skillonomy" platform and the token exchange.
 */
trait PlatformUser {
  val exchangeRate: Double = 10.0d

  private var _money: Double = 0.0d
  private var _tokens: Double = 0.0d

  def money: Double = _money

  def tokens: Double = _tokens

  /** Buy tokens for money from a bank card.
   *
   * @param amount How many tokens to buy
   */
  def addTokens(amount: Double): Unit =
    _tokens = _tokens + amount

  /** Transfer money from a bank card.
   *
   * @param amount How many money to transfer
   */
  def addMoney(amount: Double): Unit =
    _money = _money + amount

  /** Sell tokens on the exchange.
   *
   * @param amount How many tokens to sell
   */
  def sellTokens(amount: Double): Unit =
    ensureEnoughTokens(_tokens, amount)
    val earnings = tokensToMoney(amount)
    _tokens = _tokens - amount
    _money = _money + earnings

  def tokensToMoney(amount: Double): Double =
    amount * exchangeRate

  /** Buy tokens on the exchange.
   *
   * @param amount How many tokens to buy
   */
  def buyTokens(amount: Double): Unit =
    val price = tokensToMoney(amount)
    ensureEnoughMoney(_money, price)
    _money = _money - price
    _tokens = _tokens + amount

  private def ensureEnoughMoney(provided: Double, required: Double): Unit =
    val message = "Not enough money to complete the transaction."
    if (provided < required) throw new NotEnoughMoneyException(
      required, provided, message
    )

  /** Transfer tokens to another user.
   *
   * @param recipient The user who will receive the tokens
   * @param amount    How many tokens to transfer
   */
  def transferTokens(recipient: PlatformUser, amount: Double): Unit =
    ensureEnoughTokens(_tokens, amount)
    _tokens = _tokens - amount
    recipient._tokens = recipient._tokens + amount

  private def ensureEnoughTokens(provided: Double, required: Double): Unit =
    val message = "Not enough tokens to complete the transaction."
    if (provided < required) throw new NotEnoughTokensException(
      required, provided, message
    )

  /** Transfer money to another user.
   *
   * @param recipient The user who will receive the money
   * @param amount    How many money to transfer
   */
  def transferMoney(recipient: PlatformUser, amount: Double): Unit =
    ensureEnoughMoney(_money, amount)
    _money = _money - amount
    recipient._money = recipient._money + amount

  def moneyToTokens(amount: Double): Double =
    amount / exchangeRate

}
