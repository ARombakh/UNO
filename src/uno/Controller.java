/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uno;

import java.util.Scanner;
import uno.Card.Color;
import static uno.UNO.PLAYERS_QTY;

/**
 *
 * @author artyom
 */
public class Controller {
    private Deck deck;
    private Player[] players;
    private int playerIX;
    public Card lastCard;
    public final static int CARDS_FINE = 4;
    
    public Controller(Deck deck, Player[] players,
            int playerIX,
            Card lastCard) {
        this.deck = deck;
        this.players = players;
        this.playerIX = playerIX;
        this.lastCard = lastCard;
    }
    
    public void takeCards(Integer cardsToTake) {
        if(cardsToTake == null) {
            cardsToTake = cntTakeCards(lastCard);
        }
        for (int i = 0; i < cardsToTake; i++) {
            players[playerIX].addCard(deck.extractRandCard());
        }
        System.out.println(cardsToTake + " cards taken by player "
                        + playerIX);
    }
    
    public int cntTakeCards(Card card) {
        if (card.getCardtype() == Card.CardType.DRAW_2) {
            return 2;
        }
        
        if (card.getCardtype() == Card.CardType.WILD_DRAW_4) {
            return 4;
        }
        
        return 0;
    }

    public Color chooseColor() {
        PlayerAction pa = new PlayerAction(players, playerIX);
        UI ui = new UI();
        System.out.println("Select a color of the WILD CARD:");
        ChooseColor chooseColor = (ChooseColor)ui.askAction(pa.formColorMenu());
        return chooseColor.getColor();
    }
    
    public void sayUno() {
        PlayerAction pa = new PlayerAction(players, playerIX);
        UI ui = new UI();
        System.out.println("Choose to say \"Uno!\"");
        
        SayUno sayUno = (SayUno)ui.askAction(pa.formUnoMenuList());
        if (!players[playerIX].isUnoSaid()) {
            if (!players[playerIX].setUnoSaid(sayUno.isSayUno())) {
                takeCards(CARDS_FINE);
                System.out.println("Uno said in incorrect situation!");
            }
        }
    }

    public Card playNewCard(int cardIX) {
        boolean askingCard = true;
        PlayerAction pa = new PlayerAction(players, playerIX);
        UI ui = new UI();
        Card card = null;
        
        while (askingCard) {
            System.out.println("Current card to match:");
            System.out.println(lastCard);
            System.out.println("Play taken card or skip turn:\n");
            Action action = ui.askAction(pa.formOneCard(cardIX));
            if (action instanceof SkipTurn) {
                card = null;
                askingCard = false;
            } else {
                if (action instanceof PlayCard playCard) {
                    card = playCardCommon(playCard);
                    askingCard = card == null;
                } else {
                    throw new IllegalArgumentException("Illegal action");
                }
            }
        }
        
        return card;
    }

    public Card playCardCommon(PlayCard playCard) {
        Card card;
        
        int cardIX = playCard.getCardIX();

        card = players[playerIX].getCard(cardIX);

        if (lastCard.discardMatchesNew(card)) {
            card = players[playerIX].extractCard(cardIX);                    
            if (card.getCardtype() == Card.CardType.WILD_DRAW_4 ||
                card.getCardtype() == Card.CardType.WILD) {
                card.setColor(chooseColor());
            }
            System.out.println("Card successfully put");
            return card;
        } else {
            System.out.println("Can't use this card, "
                    + "choose another one or skip turn");
            return null;
        }
    }

    public Card playCard() {
        boolean turnOver = false;
        Card card = null;

        while (!turnOver) {
            System.out.println("Current card to match:");
            System.out.println(lastCard);

            PlayerAction pa = new PlayerAction(players, playerIX);

            UI ui = new UI();
            System.out.println("Select action:\n");
            Action action = ui.askAction(pa.formInitMenuList());
            
            if (action instanceof PlayCard playCard) {
                card = playCardCommon(playCard);
                if (card != null) {
                    turnOver = true;
                }
            } else {
                if (action instanceof TakeCard) {
                    card = deck.extractRandCard();
                    System.out.println("The player took card:\n" + card);
                    card = playNewCard(players[playerIX].addCard(card));
                    turnOver = true;
                } else {
                    if (action instanceof SpotPlayer sp) {
                        spotPlayer(sp.getPlayerIX());
                    } else {
                        throw new IllegalArgumentException("Illegal action");
                    }
                }
            }
        }

        return card;
    }
    
    public void spotPlayer(int playerIXsp) {
        if (!players[playerIXsp].spotted(deck)) {
            System.out.println("Wrong spotting. Player " + playerIX + 
                    " takes " + CARDS_FINE + " cards");
            takeCards(CARDS_FINE);
        } else {
            System.out.println("Correct spotting. Player " + playerIXsp +
                    " takes " + CARDS_FINE + " cards");
        }
    }
       
    public Card makeTurn(boolean isSkip) {
        Card card;

        for (int i = 0; i < players.length; i++) {
            if (i != playerIX) {
                System.out.println("Player " + i + " has " +
                        players[i].getSize() + " cards. " +
                        (players[i].isUnoSaid() ?  "Uno said" : ""));
            }
        }
        
        System.out.println("\n\nPlayer's " + playerIX + " turn");
        
        if (!isSkip) {
            card = playCard();
        } else {
            System.out.println("The Player " + playerIX +
                " skips the turn");            
            takeCards(null);
            card = null;
        }
        
        sayUno();

        return card;
    }
}
