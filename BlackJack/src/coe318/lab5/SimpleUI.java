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
import java.util.Scanner;

public class SimpleUI implements UserInterface {
    
    private BlackjackGame games;
    private Scanner userinput = new Scanner(System.in);

  @Override
    public void setGame(BlackjackGame game) {
        
        this.games = game;
        
    }

  @Override
    public void display() {
        
    System.out.println("House holds:\n" + this.games.getHouseCards().toString());
    System.out.println("You hold:\n" + this.games.getYourCards().toString());
        //FIX THIS
        
    }

  @Override
    public boolean hitMe() {
        
    System.out.println("Would you like another card? (y/n)");
    String choice = userinput.nextLine();
    boolean hit = false;
    
    switch(choice){
        case "y":
        hit = true;
        break;
        case "n":
        hit = false;
        break;
        default:
        System.out.println("Please select (y/n)\n");
        hitMe();
    }
    
    return hit;
        
    }
  @Override
    public void gameOver() {
        
        this.display();
        int PlayerScore = games.score(games.getYourCards());
        int HouseScore = games.score(games.getHouseCards());
        
        System.out.println("Your Score: " + PlayerScore + ", House Score: " + HouseScore);
        if((PlayerScore > HouseScore || HouseScore > 21) && (PlayerScore <= 21)) {
            
            System.out.println("You win!");
        }
        
        else {
            
            System.out.println("The House wins!");
            
        }    
        
    }

}