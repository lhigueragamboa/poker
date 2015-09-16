package poker

import scala.collection.mutable.HashMap
import scala.collection.immutable.{ Set, ListMap, SortedSet }

case class Hand(
    private val cards: SortedSet[Card],
    private val frequenciesToSize: Map[Int, Int],
    private val inputCards: (Card, Card, Card, Card, Card)
) extends Ordered[Hand] {
  val kind: HandKind = {
    def isOnePair: Boolean = frequenciesToSize.contains(2)

    def isTwoPairs: Boolean = isOnePair && frequenciesToSize.get(2).get == 2

    def isThreeOfAKind: Boolean = frequenciesToSize.contains(3)

    def isStraight: Boolean = {
      def areConsecutive(firstCard: Card, secondCard: Card): Boolean =
        secondCard.rank.value - firstCard.rank.value == 1
      val allCardsAreConsecutive =
        cards.view.zip(cards.tail).forall { case (firstCard, secondCard) =>
          areConsecutive(firstCard, secondCard)
        }
      val thereIsoneCardPerKind = frequenciesToSize.keys.forall { frequency => frequency == 1 }
      allCardsAreConsecutive && thereIsoneCardPerKind
    }

    def isFlush: Boolean = {
      val suit = cards.head.suit
      cards.forall { card => card.suit == suit }
    }

    def isFullHouse: Boolean = isOnePair && isThreeOfAKind

    def isFourOfAKind: Boolean = frequenciesToSize.contains(4)

    def isStraightFlush: Boolean = isStraight && isFlush

    def isRoyalFlush: Boolean = {
      val lowestCard = cards.head
      isStraightFlush && lowestCard.rank == Ten
    }

    if (isRoyalFlush) RoyalFlush
    else if (isStraightFlush) StraightFlush
    else if (isFourOfAKind) FourOfAKind
    else if (isFullHouse) FullHouse
    else if (isFlush) Flush
    else if (isStraight) Straight
    else if (isThreeOfAKind) ThreeOfAKind
    else if (isTwoPairs) TwoPairs
    else if (isOnePair) OnePair
    else HighCard
  }

  def compare(that: Hand): Int = this.kind compare that.kind
  
  override def toString(): String = inputCards.toString()
}

case object Hand {
  def apply(inputCards: (Card, Card, Card, Card, Card)): Hand = {
    val cardsToFrequencies = HashMap[Card, Int]()
    inputCards.productIterator.foreach { c =>
      val card = c.asInstanceOf[Card]
      val previousValue = cardsToFrequencies.getOrElse(card, 0)
      cardsToFrequencies(card) = previousValue + 1
    }
    val cards = SortedSet[Card]() ++ cardsToFrequencies.keySet
    val frequenciesToSize = cardsToFrequencies.groupBy(_._2).mapValues(_.keys.toSet.size)
    new Hand(cards, frequenciesToSize, inputCards)
  }
  
  def bestOf(hands: Hand*): Hand = {
    var best = hands.head
    hands.foreach { hand => if (hand > best) best = hand }
    best
  }
}
