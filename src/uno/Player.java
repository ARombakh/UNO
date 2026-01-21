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
    
    public int getSize() {
        return cards.size();
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
    
    public ArrayList<String> outputOptions(boolean takeCardExists,
            boolean chooseColor) {
        ArrayList<String> options = new ArrayList<>();
        
        if(takeCardExists) {
            options.add("Take card from the deck\n");
        }
        
        options.add("Say Uno\n");
        
        if (chooseColor) {
            for (Card.Color color : Card.Color.values()) {
                options.add(color.name());
            }
        } else {
            for (Card card : cards) {
                options.add(card.toString());
            }            
        }

        return options;
    }
    
    @Override
    public String toString() {
        String result = "";
        
        for (Object card : cards) {
            result += card.toString();
        }
        
        return result;
    }
}
