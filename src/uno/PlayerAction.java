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
    private ArrayList<MenuItem> menuItems;
    
    public PlayerAction(Player[] players, int playerIX) {
        this.players = players;
        this.playerIX = playerIX;
        menuItems = new ArrayList<>();
    }

    public ArrayList<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void formMenuList() {
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
    
    public Color askColor() {
        int menuItem = 0;
        System.out.println("Choose color:");
        
        for (Object value : Color.values()) {
            System.out.println(menuItem + ". " + value.toString());
            menuItem++;
        }
        
        int option = sca.promptUser();
        action = new ChooseColor(option);
        
        menuItem = 0;
        
        for (Object value : Color.values()) {
            if (option == menuItem) {
                return (Color) value;
            }
            menuItem++;
        }
        
        return null;
    }*/
    /*
    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.initDeck();
        
        Player[] players = new Player[UNO.PLAYERS_QTY];
        
        for (int i = 0; i < UNO.PLAYERS_QTY; i++) {
           players[i] = new Player();
           players[i].fillHand(deck);
        }
        
        int currPlayer = 0;
        
        PlayerAction pa = new PlayerAction(players, currPlayer);
        
        pa.formMenuList();
        
        for (int i = 0; i < pa.menuItems.size(); i++) {
            System.out.print(i + ". " + pa.menuItems.get(i));
        }
        
        UI ui = new UI();
        
        Action action = ui.askAction(pa.menuItems);
        
        if (action instanceof TakeCard) {
            System.out.println("TakeCard");
        }
        
        if (action instanceof PlayCard pc) {
            System.out.println("Playing card " +
                    players[currPlayer].extractCard(pc.getCardIX()));
        }
        
        if (action instanceof SpotPlayer sp) {
            System.out.println("Spotting player " +
                    players[sp.getPlayerIX()].toString());
        }
    }*/
}