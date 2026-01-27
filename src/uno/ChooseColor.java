/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uno;

import uno.Card.Color;

/**
 *
 * @author artyom
 */
public class ChooseColor extends Action {
    private Color color;
    
    public ChooseColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
