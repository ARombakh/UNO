/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package uno;

import java.util.ArrayList;

/**
 *
 * @author artyom
 */
public class UNO {
    public static final int CARDS_ON_HAND = 2;
    public static final int PLAYERS_QTY = 3;
    private int direction;
    
    public boolean isSkip(Card card) {
        return card.getCardtype() == Card.CardType.SKIP ||
            card.getCardtype() == Card.CardType.DRAW_2 ||
            card.getCardtype() == Card.CardType.WILD_DRAW_4;
    }
    
    public int nextPlOrder(int playerIX) {
        if (playerIX + direction == -1) {
            return PLAYERS_QTY - 1;
        } else {
            if (playerIX + direction == PLAYERS_QTY) {
                return 0;
            } else {
                return playerIX + direction;
            }
        }
    }
    
    public int nextPlayer(int playerIX, Card card) {
        int nextPlayerIX;
        if (card.getCardtype() == Card.CardType.REVERSE) {
            this.direction = - this.direction;
        }
        
        nextPlayerIX = nextPlOrder(playerIX);
        
        return nextPlayerIX;
    }
    
    public Integer checkPlayersCards(ArrayList<Player> players) {
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getSize() == 0) {
                return i;
            }
        }
        
        return null;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UNO uno = new UNO();
        uno.direction = 1;
        
        Deck deck = new Deck();
        deck.initDeck();
        
        ArrayList<Player> players = new ArrayList<>();
        
        for (int i = 0; i < PLAYERS_QTY; i++) {
//            players.get(i) = new Player();
            players.get(i).fillHand(deck);
        }

        Deck discardPile = new Deck();
        
        discardPile.addCard(deck.extractRandCard());
        
        Controller controller;
        
        int currPlayerIX = 0;
        Card card;
        boolean isSkip = false;

        Integer winningPlayer = 0;
        while ((winningPlayer = uno.checkPlayersCards(players)) == null) {
            controller = new Controller(deck, players,
                    currPlayerIX,
                    discardPile.getLastCard());
            card = controller.makeTurn(isSkip);   // isSkip
            if (card != null) {
                discardPile.addCard(card);
                isSkip = uno.isSkip(card);
            } else {
                isSkip = false;
            }            
            currPlayerIX = uno.nextPlayer(currPlayerIX,
                    discardPile.getLastCard());
        }
        
        System.out.println("The player " + winningPlayer + " has won!");
    }
}
