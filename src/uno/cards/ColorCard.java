/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uno.cards;

import static uno.cards.Card.CardType.COLOR;

/**
 *
 * @author artyom
 */
public class ColorCard extends Card {
    public enum Color {
        RED,
        YELLOW,
        BLUE,
        GREEN
    }
    
    public enum ColorType {
        NUMBER,
        REVERSE,
        SKIP,
        DRAW_2
    }
    
    protected ColorType colortype;
    protected Color color;
    
    public ColorCard(Color color, ColorType colortype) {
        super(COLOR);
        this.color = color;
        this.colortype = colortype;
    }
}
