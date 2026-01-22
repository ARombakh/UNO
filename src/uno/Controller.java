/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uno;

import java.util.Scanner;
import static uno.UNO.PLAYERS_QTY;

/**
 *
 * @author artyom
 */
public class Controller {
    private Deck deck;
    private Player[] players;
    public Deck discardPile;
    private int direction;
    
    public Controller(Deck deck, Player[] players, Deck discardPile) {
        this.deck = deck;
        this.players = players;
        this.discardPile = discardPile;
        this.direction = 1;
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
        boolean skip = false;  // Skipping player or not
        int nextPlayerIX;
        if (card.getCardtype() == Card.CardType.REVERSE) {
            this.direction = - this.direction;
        }
        
        if (card.getCardtype() == Card.CardType.SKIP ||
            card.getCardtype() == Card.CardType.DRAW_2 ||
            card.getCardtype() == Card.CardType.WILD_DRAW_4) {
            skip = true;
        }
        
        nextPlayerIX = nextPlOrder(playerIX);
        if (skip) nextPlayerIX = nextPlOrder(nextPlayerIX);
        
        return nextPlayerIX;
    }
    
    public int takeCards(Card card) {
        if (card.getCardtype() == Card.CardType.DRAW_2) {
            return 2;
        }
        
        if (card.getCardtype() == Card.CardType.WILD_DRAW_4) {
            return 4;
        }
        
        return 0;
    }
    
    public Integer checkPlayersCards(Player[] players) {
        for (int i = 0; i < players.length; i++) {
            if (players[i].getSize() == 0) {
                return i;
            }
        }
        
        return null;
    }

    public Card makeTurn(int playerIX, int cardsToTake) {
        for (int i = 0; i < cardsToTake; i++) {
            players[playerIX].addCard(deck.extractRandCard());
        }
        
        Scanning sca = new Scanning();
        boolean turnOver = false;
        Card card = null;
        
        while (!turnOver) {
            System.out.println("Current card to match:");
            System.out.println(discardPile.getLastCard());

            System.out.println("Choose card index:");
            System.out.println(players[playerIX]);

            card = players[playerIX].extractCard(sca.promptUser());

            if (discardPile.getLastCard().matches(card)) {
                System.out.println("Card successfully put");
                turnOver = true;
            } else {
                System.out.println("Can't use this card, choose another one");
            }            
        }
        return card;
    }
}
