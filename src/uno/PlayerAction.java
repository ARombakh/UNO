/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uno;

import java.util.ArrayList;
import uno.Card.Color;
import uno.UNO;

/**
 *
 * @author artyom
 */
public class PlayerAction {
    private Player[] players;
    private int playerIX;
    /*private ArrayList<MenuItem> menuItems;*/
    
    public PlayerAction(Player[] players, int playerIX) {
        this.players = players;
        this.playerIX = playerIX;
        /*menuItems = new ArrayList<>();*/
    }
    /*
    public ArrayList<MenuItem> getMenuItems() {
        return menuItems;
    }*/

    public ArrayList<MenuItem> formInitMenuList() {        
        ArrayList<MenuItem> menuItems = new ArrayList<>();
        
        MenuItem menuItem = new MenuItem("Take Card\n", new TakeCard());

        menuItems.add(menuItem);
        
        Card card;
        
        for (int i = 0; i < players[playerIX].getSize(); i++) {
            card = players[playerIX].getCard(i);
            
            menuItem = new MenuItem("Play\n" + card.toString(),
                    new PlayCard(i));
            
            menuItems.add(menuItem);
        }
        
        for (int i = 0; i < players.length; i++) {
            if (i != playerIX) {
                menuItem = new MenuItem("Spot player " + i + "\n", 
                    new SpotPlayer(playerIX));
                menuItems.add(menuItem);
            }
        }
        
        return menuItems;
    }
    /*
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
    */
    public ArrayList<MenuItem> formColorMenu() {
        ArrayList<MenuItem> menuItems = new ArrayList<>();
        
        MenuItem menuItem;
        
        for (Color value : Color.values()) {
            menuItem = new MenuItem(value.toString() + "\n",
                    new ChooseColor(value));
            menuItems.add(menuItem);
        }

        return menuItems;
    }
}