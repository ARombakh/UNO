/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uno;

import java.util.ArrayList;
import java.util.Random;
import uno.cards.Card;
import uno.cards.ColorCard.Color;
import uno.cards.Draw2Card;
import uno.cards.NumberCard;
import static uno.cards.NumberCard.END_RANGE;
import static uno.cards.NumberCard.START_RANGE;
import uno.cards.ReverseCard;
import uno.cards.SkipCard;
import uno.cards.WildCard;

/**
 *
 * @author artyom
 */
public class Deck {
    public static final int COLOR_CARDS_QTY = 10;
    private ArrayList<Card> cards;
    
    public Deck() {
        this.cards = new ArrayList<>();
        
        Card card;
        
        for (Color color : Color.values()) {
            for (int i = START_RANGE; i <= END_RANGE; i++) {
                if (i != 0) {
                    card = new NumberCard(color, i);
                    addCard(card);                    
                }                
                card = new NumberCard(color, i);
                addCard(card);
            }
            
            for (int i = 0; i < 2; i++) {
                card = new ReverseCard(color);
                addCard(card);
                card = new SkipCard(color);
                addCard(card);
                card = new Draw2Card(color); 
                addCard(card);
            }
        }
        
        for (int i = 0; i < 4; i++) {
            card = new WildCard(true);
            addCard(card);
            card = new WildCard(false);
            addCard(card);
        }
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
