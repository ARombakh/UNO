/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uno;

/**
 *
 * @author artyom
 */
public class Card {
    public enum CardType {
        NUMBER,
        REVERSE,
        SKIP,
        DRAW_2,
        WILD_DRAW_4,
        WILD
    }
    
    public enum Color {
        RED,
        YELLOW,
        BLUE,
        GREEN
    }
    
    private CardType cardtype;
    private Color color;
    private Integer number;
    
    public Card(CardType cardtype) {
        this.cardtype = cardtype;
    }

    public Card(CardType cardtype, Color color) {
        this(cardtype);
        this.color = color;
    }
    
    public Card(CardType cardtype, Color color, Integer number) {
        this(CardType.NUMBER);
        this.color = color;
        this.number = number;
    }

    public CardType getCardtype() {
        return cardtype;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    
    public void resetColor() {
        setColor(null);
    }

    public void setNumber(int number) throws Exception {
        if (cardtype != CardType.NUMBER) {
            throw new Exception("Cannot assign number to non-number card");
        }
        this.number = number;
    }

    // Function to match card from discard pile with card extracted from hand
    public boolean discardMatchesNew(Card c) {
        if (c == null) return false;
        
        // If the color of card in hand is null, it means it is wildcard and
        // therefore true
        if (c.color == null || this.color == c.color) return true;

        if (this.cardtype == CardType.NUMBER &&
            c.cardtype == CardType.NUMBER &&
            this.number.equals(c.number)) return true;
        
        return false;
    }
    
    @Override
    public String toString() {
        return "Type " + cardtype + "\n" +
                "Color " + color + "\n" +
                "Number " + number + "\n";
    }
}