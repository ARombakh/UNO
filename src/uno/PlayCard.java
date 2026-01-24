/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uno;

/**
 *
 * @author artyom
 */
public class PlayCard extends Action {
    private int cardIX;
    
    public PlayCard(int cardIX) {
        this.cardIX = cardIX;
    }

    public int getCardIX() {
        return cardIX;
    }
}
