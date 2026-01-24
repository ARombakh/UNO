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
    private Player player;   // Change to player
    public Deck discardPile;    // Change to current card
    
    public Controller(Deck deck, Player player, Deck discardPile) {
        this.deck = deck;
        this.player = player;
        this.discardPile = discardPile;
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
       
    public Card makeTurn() {
        int cardsToTake = takeCards(discardPile.getLastCard());
        for (int i = 0; i < cardsToTake; i++) {
            player.addCard(deck.extractRandCard());
        }
        
        Scanning sca = new Scanning();
        boolean turnOver = false;
        Card card = null;
        
        while (!turnOver) {
            System.out.println("Current card to match:");
            System.out.println(discardPile.getLastCard());
        
            System.out.println("Choose card index:");
            System.out.println(player);

            card = player.extractCard(sca.promptUser());

            if (discardPile.getLastCard().discardMatchesNew(card)) {
                System.out.println("Card successfully put");
                turnOver = true;
            } else {
                System.out.println("Can't use this card, choose another one");
            }            
        }
        return card;
    }
}
