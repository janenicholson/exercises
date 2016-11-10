
public class Hand {
    private String hand;
    public Hand(String hand) {
        this.hand = hand;
    }

    public Points value() {
        Points points=Points.zero;
        CardScorer cardScorer = new CardScorer();
        for(int index=0; index < hand.length(); index++) {
            Card card = new Card(hand.charAt(index));
            points = points.plus(cardScorer.score(card));
        }
        return points;
    }

}
