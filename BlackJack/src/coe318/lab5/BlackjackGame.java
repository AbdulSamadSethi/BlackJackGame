/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe318.lab5;

/**
 *
 * @author ABdul Samad Sethi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

public class BlackjackGame {

  private CardPile deck;
  private CardPile househand;
  private CardPile yourhand;
  private boolean housedone;
  private boolean playerdone;
  private UserInterface ui;

  public BlackjackGame(UserInterface ui) {
      
    this.ui = ui;
    ui.setGame(this);
    deck = new CardPile();
    
    for (int i = 2; i < 15; i++) {
        
      for (int j = 0; j < 4; j++) {
          
        deck.add(new Card(i, j, true));
        
      }
    }
    
    househand = new CardPile();
    yourhand = new CardPile();
    housedone = false;
    housedone = false;
    
  }

  public void start() {
      
    Card c;
    c = deck.removeRandom();
    c.setFaceUp(false);
    getHouseCards().add(c);
    getHouseCards().add(deck.removeRandom());
    getYourCards().add(deck.removeRandom());
    getYourCards().add(deck.removeRandom());
    ui.display();
    
  }

  public void play() {
    while (!housedone || !playerdone) {
      if (!housedone) {
          
        if (score(getHouseCards()) <= 17) {
            
          getHouseCards().add(deck.removeRandom());
          ui.display();
          
        } else {
            
          housedone = true;
          
        }
      }
      
      if (!playerdone) {
          
        if (ui.hitMe()) {
            
          getYourCards().add(deck.removeRandom());
          ui.display();
          
        } else {
            
          playerdone = true;
          
        }
      }
    }
  }

  public void end() {
    getHouseCards().getCards().get(0).setFaceUp(true);
    ui.gameOver();
  }

  /**
   * Determine the score of a pile of cards.
   *
   * @param p
   * @return the score
   */
  public int score(CardPile p) {
      
    int myscore = 0;
    for(Card c : p.getCards()) {
        myscore = myscore + c.getRank();
    }  
    
    return myscore;
    
  }

  /**
   * @return the houseCards
   */
  public CardPile getHouseCards() {
      
    return househand;
    
  }

  /**
   * @return the yourCards
   */
  public CardPile getYourCards() {
      
    return yourhand;
    
  }

  public static void main(String[] args) {
      
    BlackjackGame game = new BlackjackGame(new SimpleUI());
    game.start();
    game.play();
    game.end();
    
  }
}