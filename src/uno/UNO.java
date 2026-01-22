/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package uno;

/**
 *
 * @author artyom
 */
public class UNO {
    public static final int CARDS_ON_HAND = 7;
    public static final int PLAYERS_QTY = 3;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.initDeck();
        
        Player[] players = new Player[PLAYERS_QTY];
        
        for (int i = 0; i < PLAYERS_QTY; i++) {
            players[i] = new Player();
            players[i].fillHand(deck);
        }

        Deck discardPile = new Deck();
        
        discardPile.addCard(deck.extractRandCard());
        
        Controller controller = new Controller(deck, players, discardPile);
        
        int currPlayerIX = 0;
        int turns = 5;
        int turn = 0;

        while (controller.checkPlayersCards(players) == null) {
            System.out.println("Player " + currPlayerIX);
            discardPile.addCard(controller.makeTurn(currPlayerIX, 0));
            currPlayerIX = controller.nextPlayer(currPlayerIX,
                    discardPile.getLastCard());
        }
    }
}
