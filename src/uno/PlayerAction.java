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
    
    public PlayerAction(Player[] players, int playerIX) {
        this.players = players;
        this.playerIX = playerIX;
    }
    
    public ArrayList<MenuItem> formUnoMenuList() {
        ArrayList<MenuItem> menuItems = new ArrayList<>();
        
        MenuItem menuItem = new MenuItem("Say \"Uno!\"\n", new SayUno(true));
        menuItems.add(menuItem);
        
        menuItem = new MenuItem("Don't say\n", new SayUno(false));
        menuItems.add(menuItem);
        
        return menuItems;
    }
    
    public ArrayList<MenuItem> formOneCard(int cardIX) {
        ArrayList<MenuItem> menuItems = new ArrayList<>();
        MenuItem menuItem = new MenuItem("Skip turn", new SkipTurn());
        menuItems.add(menuItem);
        
        menuItem = new MenuItem("Play\n" + players[playerIX].getCard(cardIX),
                new PlayCard(cardIX));
        menuItems.add(menuItem);
        
        return menuItems;
    }

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
                    new SpotPlayer(i));
                menuItems.add(menuItem);
            }
        }
        
        return menuItems;
    }

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