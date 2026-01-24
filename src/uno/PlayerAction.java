/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uno;

/**
 *
 * @author artyom
 */
public class PlayerAction {
    private Player player;
    private Scanning sca;
    private Action action;
    
    public PlayerAction(Player player) {
        this.player = player;
        sca = new Scanning();
    }
    
    public Action askAction() {
        int offset = 0;
                        
        System.out.println("Choose action:");
        System.out.println("0. Take a card");

        offset++;
        
        for (int i = 0; i < player.getSize(); i++) {
            System.out.print((i+offset) + ". " + player.getCard(i));
        }
        
        int option = sca.promptUser();
        
        if (option == 0) {
            action = new TakeCard();
            
        } else {
            action = new PlayCard(option - offset);
        }
        
        return action;
    }
}