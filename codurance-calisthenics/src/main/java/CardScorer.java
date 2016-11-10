
public class CardScorer {

    public Points score(Card card) {
        if (card.equals(new Card('A')))
            return new Points(4);
        if (card.equals(new Card('K')))
            return new Points(3);
        return new Points(2);
    }

}
