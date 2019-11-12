/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe318.lab5;

/**
 *
 * @author Abdul Samad Sethi
 */
import java.util.ArrayList;

/**
 * A pile of cards.
 *
 */
public class CardPile {
    //Instance variables
    private ArrayList<Card> cards;

    public CardPile() {
        //Initialize the instance variable.
        cards = new ArrayList<Card>();
    }
    
    /**
     * Add a card to the pile.
     * @param card
     */
    public void add(Card card) {
        
        cards.add(card);
        //FIX THIS
    }

    /**
     * Remove a card chosen at random from the pile.
     * @return
     */
    public Card removeRandom() {
        
        int cardnumber = (int)(Math.random()*cards.size());
        
        return this.cards.remove(cardnumber); //FIX THIS
        
    }

    /**
     * The string representation is a space separated list
     * of each card.
     * @return
     */
    @Override
    public String toString() {
        
        String piles = "";
        for(Card c : this.cards) {
            
            piles = piles + c.toString() + "\n";
            
        }
        
        return piles;
    }
    
    /**
     * @return the cards
     */
    public ArrayList<Card> getCards() {
        
        return cards;
        
    }

    public static void main(String[] args) {
        CardPile p = new CardPile();
        p.add(new Card(2, 1, true));
        p.add(new Card(3, 2, true));
        p.add(new Card(4, 3, false));
        p.add(new Card(14, 1, true));
        System.out.println("Removed: " + p.removeRandom());
        System.out.println("Removed: " + p.removeRandom());
        System.out.println("Removed: " + p.removeRandom());
        System.out.println("Removed: " + p.removeRandom());
        System.out.println("");
        CardPile deck = new CardPile();
        for(int i = 2; i < 15; i++) {
            for(int j = 0; j < 4; j++) {
                deck.add(new Card(i, j, true));
            }
        }
        for (int i = 0; i < 52; i++) {
            System.out.println((i+1) + ": " + deck.removeRandom());

        }
    }


}