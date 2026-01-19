/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uno.cards;

import static uno.cards.ColorCard.ColorType.NUMBER;

/**
 *
 * @author artyom
 */
public class NumberCard extends ColorCard {
    public static final int START_RANGE = 0;
    public static final int END_RANGE = 9;
    
    private int number;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        if (!(number >= START_RANGE && number <= END_RANGE)) {
            throw new IllegalArgumentException("Card number is not in range "
                    + START_RANGE + " to " + END_RANGE);
        }
        this.number = number;
    }
    
    public NumberCard(Color color, int number) {
        super(color, NUMBER);
        setNumber(number);
    }
    
    @Override
    public String toString() {
        return "Type " + this.cardtype + "\n" +
                "Color " + this.color + "\n" +
                "ColorType " + this.colortype + "\n" +
                "Number " + this.number + "\n";
    }
}
