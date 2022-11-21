package calculator.models

import scala.annotation.targetName
import scala.math.{atan, pow, sqrt}

class Complex(var real: Double, var imag: Double) {
  
  override def toString: String = f"$real+${imag}i"
  
  def set_real(real: Double): Unit =
    this.real = real
  
  def set_imag(imag: Double): Unit =
    this.imag = imag

  def conjugate: Complex =
    Complex(real, -imag)

  def module: Double =
    sqrt(pow(real, 2) + pow(imag, 2))

  def arg: Double =
    atan(imag / real)

  def +(that: Complex): Complex =
    Complex(real + that.real, imag + that.imag)

  def +(that: Double): Complex =
    Complex(real + that, imag)

  def -(that: Complex): Complex =
    Complex(real - that.real, imag - that.imag)

  def -(that: Double): Complex =
    Complex(real - that, imag)

  def *(that: Complex): Complex =
    Complex(
      (real * that.real) - (imag * that.imag),
      (imag * that.real) + (real * that.imag)
    )

  def *(that: Double): Complex =
    Complex(real * that, imag * that)

  def /(that: Complex): Complex =
    val numeratorReal = (real * that.real) + (imag * that.imag)
    val numeratorImag = (imag * that.real) - (real * that.imag)
    val denominator = pow(that.real, 2) + pow(that.imag, 2)
    Complex(numeratorReal / denominator, numeratorImag / denominator)

  def ==(that: Complex): Boolean =
    (real == that.real) && (imag == that.imag)
}
