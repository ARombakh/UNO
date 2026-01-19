/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uno.cards;

/**
 *
 * @author artyom
 */
public class WildCard extends Card {
    private boolean isDraw4;
    
    public WildCard(boolean isDraw4) {
        super(CardType.WILD);
        this.isDraw4 = isDraw4;
    }
    
    @Override
    public String toString() {
        return "Type " + this.cardtype + "\n" +
                "Draw 4 " + this.isDraw4;
    }
}
