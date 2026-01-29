/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uno;

import java.util.ArrayList;

/**
 *
 * @author artyom
 */
public class Player {
    private ArrayList<Card> cards;
    private boolean unoSaid;
    
    public Player() {
        cards = new ArrayList<>();
        unoSaid = false;
    }
    
    public ArrayList<Card> getCards() {
        return cards;
    }

    public boolean isUnoSaid() {
        return unoSaid;
    }

    public boolean setUnoSaid(boolean unoSaid) {
        if (unoSaid) {
            if (cards.size() == 1) {
                this.unoSaid = unoSaid;
                return true;
            } else {
                return false;
            }
        } else {
            this.unoSaid = unoSaid;
            return true;
        }
    }
    
    public int getSize() {
        cards.trimToSize();
        return cards.size();
    }
    
    public Card getCard(int i) {
        return cards.get(i);
    }
    
    public int addCard(Card card) {
        cards.add(card);
        if (cards.size() > 1) {
            this.setUnoSaid(false);
        }
        
        return cards.size() - 1;
    }
    
    public void fillHand(Deck deck) {
        while (cards.size() < UNO.CARDS_ON_HAND) {            
            addCard(deck.extractRandCard());
        }
    }
    
    public Card extractCard(int index) {
        return cards.remove(index);
    }
    
    public boolean spotted(Deck deck) {
        if (!unoSaid && cards.size() == 1) {
            for (int i = 0; i < Controller.CARDS_FINE; i++) {
                addCard(deck.extractRandCard());
            }
            return true;
        } else {
            return false;
        }
    }
        
    @Override
    public String toString() {
        String result = "";
        int cardNo = 0;
        
        for (Object card : cards) {
            result += cardNo + ". " + card.toString();
            cardNo++;
        }
        
        return result;
    }
}
