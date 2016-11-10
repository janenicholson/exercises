
public class Card {
    private char card;

    @Override
    public int hashCode() {
        return card;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Card &&
                this.card == ((Card)obj).card;
    }

    public Card(char c) {
        this.card = c;
    }

}
