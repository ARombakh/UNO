/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uno;

/**
 *
 * @author artyom
 */
public class ChooseColor extends Action {
    private int colorIX;
    
    public ChooseColor(int colorIX) {
        this.colorIX = colorIX;
    }

    public int getColorIX() {
        return colorIX;
    }
}
