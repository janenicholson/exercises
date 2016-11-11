
public class CardScorer {

    public Points score(Card card) {
        if (card.equals(new Card('A')))
            return new Points(4);
        if (card.equals(new Card('K')))
            return new Points(3);
        if (card.equals(new Card('Q')))
            return new Points(2);
        if (card.equals(new Card('J')))
            return new Points(1);
        return new Points(0);
    }

}
