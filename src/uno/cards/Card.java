/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uno.cards;

/**
 *
 * @author artyom
 */
public class Card {
    public enum CardType {
        COLOR,
/*        REVERSE,
        SKIP,
        DRAW_2,*/
//        WILD_DRAW_4,
        WILD
    }
    
    protected CardType cardtype;
    
    public Card(CardType cardtype) {
        this.cardtype = cardtype;
    }
}
