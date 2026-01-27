/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uno;

/**
 *
 * @author artyom
 */
public class SpotPlayer extends Action {
    private int playerIX;
    
    public SpotPlayer(int playerIX) {
        this.playerIX = playerIX;
    }

    public int getPlayerIX() {
        return playerIX;
    }
}
