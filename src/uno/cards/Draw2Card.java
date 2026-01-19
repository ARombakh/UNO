/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uno.cards;

/**
 *
 * @author artyom
 */
public class Draw2Card extends ColorCard {
    public Draw2Card(Color color) {
        super(color, ColorType.DRAW_2);
    }
    
    @Override
    public String toString() {
        return "Type " + this.cardtype + "\n" +
                "Color " + this.color + "\n" +
                "ColorType " + this.colortype + "\n";
    }
}
