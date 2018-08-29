class Rational(n: Int, d: Int) {

  require(d != 0)

  private val gcd = greatestCommonDivisor(n.abs, d.abs)
  val numerator: Int = n / gcd
  val denominator: Int = d / gcd

  def this(n: Int) = this(n,1)

  override def toString: String = numerator + "/" + denominator

  def +(that: Rational) = new Rational(numerator * that.denominator + that.numerator * denominator, denominator * that.denominator)

  def +(i: Int) = new Rational(numerator + i * denominator, denominator)

  def -(that: Rational) = new Rational(numerator * that.denominator - that.numerator * denominator, denominator * that.denominator)

  def -(int: Int) = new Rational(numerator - int * denominator , denominator)

  def *(that: Rational) = new Rational(numerator * that.numerator , denominator * that.denominator)

  def *(int: Int) = new Rational(numerator*int, denominator)

  def /(that: Rational) = new Rational(numerator * that.denominator, denominator * that.numerator)

  def /(int: Int) = new Rational(numerator, denominator * int)

  def lessThan (that: Rational): Boolean = this.numerator * that.denominator < that.numerator * this.denominator

  def max(that: Rational): Rational = if (this.lessThan(that)) that else this

  private def greatestCommonDivisor(a: Int, b: Int) : Int = if (b == 0) a else greatestCommonDivisor(b, a % b)

  implicit def intToRational(x: Int): Rational = new Rational(x)
}
