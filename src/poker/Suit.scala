package poker

sealed trait Suit {
  override def toString(): String = this match {
    case Hearts => "♡"
    case Spades => "♤"
    case Diamonds => "♢"
    case Clubs => "♧"
  }
}

case object Hearts extends Suit
case object Spades extends Suit
case object Clubs extends Suit
case object Diamonds extends Suit
