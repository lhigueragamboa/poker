package poker

case class Card(rank: Rank, suit: Suit) extends Ordered[Card] {
  def compare(that: Card): Int = this.rank compare that.rank 
  
  override def toString(): String = rank.toString() + suit.toString()
}
