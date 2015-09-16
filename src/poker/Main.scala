package poker

object Main extends App {
  val hand1 = Hand((
      Card(Two, Spades),
      Card(Two, Spades),
      Card(Two, Spades),
      Card(Three, Spades),
      Card(Three, Spades)
  ))
  
  val hand2 = Hand((
      Card(Two, Spades),
      Card(Two, Spades),
      Card(Two, Spades),
      Card(Two, Spades),
      Card(Three, Hearts)
  ))
  
  val bestHand = Hand.bestOf(hand1, hand2)
  println(s"Hand: $bestHand")
  println(s"Kind: ${bestHand.kind}")
}
