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
    private Player player;
    public Card lastCard;
    
    public Controller(Deck deck, Player player, Card lastCard) {
        this.deck = deck;
        this.player = player;
        this.lastCard = lastCard;
    }
    
    public void takeCards() {
        int cardsToTake = takeCards(lastCard);
        for (int i = 0; i < cardsToTake; i++) {
            player.addCard(deck.extractRandCard());
        }
        System.out.println(cardsToTake + " cards taken");
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
    
    public Card playCard() {
        Scanning sca = new Scanning();
        boolean turnOver = false;
        Card card = null;

        while (!turnOver) {
            System.out.println("Current card to match:");
            System.out.println(lastCard);

            PlayerAction pa = new PlayerAction(player);
            Action action = pa.askAction();
            
            if (action instanceof PlayCard playCard) {
                int cardIX = playCard.getCardIX();
                
                card = player.getCard(cardIX);

                if (lastCard.discardMatchesNew(card)) {
                    card = player.extractCard(cardIX);
                    System.out.println("Card successfully put");
                    turnOver = true;
                } else {
                    System.out.println("Can't use this card,"
                            + " choose another one");
                } 
            } else {
                if (action instanceof TakeCard) {
                    card = deck.extractRandCard();
                    player.addCard(card);
                    System.out.println("The player took card:\n" + card);
                    return null;
                } else {
                    throw new IllegalArgumentException("Illegal action");
                }
            }
        }

        return card;
    }
       
    public Card makeTurn(boolean isSkip) {        
        if (!isSkip) {
            return playCard();
        } else {
            takeCards();
            return null;
        }
    }
}
