package poker

sealed abstract class Rank(val value: Int) extends Ordered[Rank] {
  def compare(that: Rank): Int = this.value - that.value;
  
  override def toString(): String = this match {
    case Ace => "A"
    case King => "K"
    case Queen => "Q"
    case Jack => "J"
    case _ => this.value.toString()
  }
}

case object Two extends Rank(value = 2)
case object Three extends Rank(value = 3)
case object Four extends Rank(value = 4)
case object Five extends Rank(value = 5)
case object Six extends Rank(value = 6)
case object Seven extends Rank(value = 7)
case object Eight extends Rank(value = 8)
case object Nine extends Rank(value = 9)
case object Ten extends Rank(value = 10)
case object Jack extends Rank(value = 11)
case object Queen extends Rank(value = 12)
case object King extends Rank(value = 13)
case object Ace extends Rank(value = 14)
