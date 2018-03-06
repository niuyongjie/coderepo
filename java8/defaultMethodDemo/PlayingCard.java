package defaultMethodDemo;

public class PlayingCard implements Card {

    private Card.Rank rank;
    private Card.Suit suit;

    public PlayingCard(Card.Rank rank, Card.Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public Suit getSuit() {
        return suit;
    }

    @Override
    public Rank getRank() {
        return rank;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Card) {
            if (((Card) obj).getRank() == this.rank &&
                    ((Card) obj).getSuit() == this.suit) {
                return true;
            }
        } else {
            return false;
        }
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return ((suit.value() - 1) * 13) + rank.value();
    }

    @Override
    public String toString() {
        return this.rank.text() + " of " + this.suit.text();
    }

    @Override
    public int compareTo(Card o) {
        return this.hashCode() - o.hashCode();
    }

    public static void main(String... args) {
        new PlayingCard(Rank.ACE, Suit.DIAMONDS);
        new PlayingCard(Rank.KING, Suit.SPADES);
    }
}
