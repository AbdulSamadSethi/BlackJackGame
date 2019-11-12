/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Abdul Samad Sethi
 */
package coe318.lab5;

public class Card implements Comparable {
  //Symbolic constants

  public static final int CLUB = 0;
  public static final int DIAMOND = 1;
  public static final int HEART = 2;
  public static final int SPADE = 3;

  public int value;
  public int type; 
  public boolean face;
  /**
   * Construct a card of the given rank, suit and whether it is faceup or
   * facedown. The rank is an integer from 2 to 14. Numbered cards (2 to 10)
   * have a rank equal to their number. Jack, Queen, King and Ace have the ranks
   * 11, 12, 13, and 14 respectively. The suit is an integer from 0 to 3 for
   * Clubs, Diamonds, Hearts and Spades respectively.
   *
   * @param rank
   * @param suit
   * @param faceUp
   */
  public Card(int rank, int suit, boolean faceUp) {
      
    value = rank;
    type = suit;
    face = faceUp;
    
  }

  /**
   * @return the faceUp
   */
  public boolean isFaceUp() {
      
    return face; 
    
  }

  /**
   * @param faceUp the faceUp to set
   */
  public void setFaceUp(boolean faceUp) {
      
      face = faceUp;
    
  }

  /**
   * @return the rank
   */
  public int getRank() {
      
    return value; 
    
  }

  /**
   * @return the suit
   */
  public int getSuit() {
      
    return type;
    
  }

  @Override
  public boolean equals(Object ob) {
      
    if (!(ob instanceof Card)) {
        
      return false;
      
    }
    Card c = (Card) ob;
    
    if(c.value == value && c.type == type){
        
        return true;
        
    }
    else{
        
        return false;
        
    }
 
  }

  @Override
  public int hashCode() {//DO NOT MODIFY
    int hash = 7;
    hash = 31 * hash + this.getRank();
    hash = 31 * hash + this.getSuit();
    return hash;
  }

  @Override
  public int compareTo(Object obj) {//DO NOT MODIFY
    return compareTo((Card) obj);
  }

  public int compareTo(Card c) {
      
      if(c.value>this.value) {
          
         return -1;
         
      }
      else if(c.value<this.value) {
          
         return 1;
         
      }
      else if(c.type>this.type) {
          
         return -1;
         
      }
      else if(c.type<this.type) {
          
          return 1;
          
      }
      else {
          
         return 0;
         
      }
      
  }

  /**
   * Return the rank as a String. For example, the 3 of Hearts produces the
   * String "3". The King of Diamonds produces the String "King".
   *
   * @return the rank String
   */
  public String getRankString() {
      
    int rank = getRank();
    
    switch(rank)
    {
        case 11:
            return "Jack";
        case 12:
            return "Queen";
        case 13:
            return "King";
        case 14:
            return "Ace";         
        default:
            return Integer.toString(rank);
    }
  }
  /**
   * Return the suit as a String: "Clubs", "Diamonds", "Hearts" or "Spades".
   *
   * @return the suit String
   */
  public String getSuitString() {
      
    int suit = getSuit();
    
    switch(suit)
    {
        case 0:
            return "Clubs";
        case 1:
            return "Diamonds";
        case 2:
            return "Hearts";
        case 3:
            return "Spades";
        default:
            return "what";
    }
    
  }

  /**
   * Return "?" if the card is facedown; otherwise, the rank and suit of the
   * card.
   *
   * @return the String representation
   */
  @Override
  public String toString() {
      
    if(face==false){
        
      return "?";
      
    }
    else
      return "" + getRankString() + " of " + getSuitString();
    //FIX THIS
    
  }

  public static void main(String[] args) {
    //Create 5 of clubs
    Card club5 = new Card(5, 0, true);
    System.out.println("club5: " + club5);
    Card spadeAce = new Card(14, SPADE, true);
    System.out.println("spadeAce: " + spadeAce);
    System.out.println("club5 compareTo spadeAce: "
            + club5.compareTo(spadeAce));
    System.out.println("club5 compareTo club5: "
            + club5.compareTo(club5));
    System.out.println("club5 equals spadeAce: "
            + club5.equals(spadeAce));
    System.out.println("club5 equals club5: "
            + club5.equals(club5));
  }
}
