package poker

sealed abstract class HandKind(val rank: Int) extends Ordered[HandKind] {
  def compare(that: HandKind): Int = this.rank - that.rank
  
  override def toString(): String = this match {
    case RoyalFlush => "royal flush"
    case StraightFlush => "straight flush"
    case FourOfAKind => "four of a kind"
    case FullHouse => "full house"
    case Flush => "flush"
    case Straight => "straight"
    case ThreeOfAKind => "three of a kind"
    case TwoPairs => "two pairs"
    case OnePair => "one pair"
    case HighCard => "high card"
  }
}

case object RoyalFlush extends HandKind(rank = 9)
case object StraightFlush extends HandKind(rank = 8)
case object FourOfAKind extends HandKind(rank = 7)
case object FullHouse extends HandKind(rank = 6)
case object Flush extends HandKind(rank = 5)
case object Straight extends HandKind(rank = 4)
case object ThreeOfAKind extends HandKind(rank = 3)
case object TwoPairs extends HandKind(rank = 2)
case object OnePair extends HandKind(rank = 1)
case object HighCard extends HandKind(rank = 0)
