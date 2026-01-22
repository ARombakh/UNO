/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uno;

import java.util.ArrayList;
import java.util.Random;
import uno.Card.Color;

/**
 *
 * @author artyom
 */
public class Deck {
    public static final int COLOR_CARDS_QTY = 10;
    public static final int START_RANGE = 0;
    public static final int END_RANGE = 9;
    private ArrayList<Card> cards;
    
    public Deck() {
        this.cards = new ArrayList<>();
    }
    
    public void initDeck() {
        Card card;
        
        for (Color color : Color.values()) {
            for (int i = START_RANGE; i <= END_RANGE; i++) {
                if (i != 0) {
                    card = new Card(Card.CardType.NUMBER, color, i);
                    addCard(card);                    
                }                
                card = new Card(Card.CardType.NUMBER, color, i);
                addCard(card);
            }
            
            for (int i = 0; i < 2; i++) {
                card = new Card(Card.CardType.REVERSE, color);
                addCard(card);
                card = new Card(Card.CardType.SKIP, color);
                addCard(card);
                card = new Card(Card.CardType.DRAW_2, color);
                addCard(card);
            }
        }

        for (int i = 0; i < 4; i++) {
            card = new Card(Card.CardType.WILD);
            addCard(card);
            card = new Card(Card.CardType.WILD_DRAW_4);
            addCard(card);
        }
    }
    
    public Card getLastCard() {
        return cards.getLast();
    }
    
    public void addCard(Card card) {
        cards.add(card);
    }
    
    public int size() {
        return cards.size();
    }
    
    public Card extractRandCard() {
        Random rand = new Random();
        return cards.remove(rand.nextInt(cards.size()));
    }
    
    @Override
    public String toString() {
        String result = "";
        for (Card card : cards) {
            result += card.toString() + "\n";
        }
        
        return result;
    }
}