/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uno;

import java.util.ArrayList;
import uno.cards.Card;

/**
 *
 * @author artyom
 */
public class Player {
    private ArrayList<Card> cards;
    
    public Player() {
        cards = new ArrayList<>();
    }
    
    public void addCard(Card card) {
        cards.add(card);
    }
    
    public void fillHand(Deck deck) {
        while (cards.size() < UNO.CARDS_ON_HAND) {            
            addCard(deck.extractRandCard());
        }
    }
    
    public Card extractCard(int index) {
        return cards.remove(index);
    }
    
    @Override
    public String toString() {
        int cardNo = 0;
        String result = "";
        
        for (Object card : cards) {
            result += cardNo + ". " + card.toString();
            cardNo++;
        }
        
        return result;
    }
}
