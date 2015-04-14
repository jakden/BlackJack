/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal.dennis;
import java.util.Random;

/**
 *
 * @author Jakden
 */
public class Hands {
    /**
     *
     */
    //Creates a random hand for players and dealers
    //RANDOM CLASS
    //INT METHOD
    public int randomCard(int handTotal){
        
        Random randCard = new Random();
        int randomCard = randCard.nextInt(10);
        randomCard += 1;
        
        
        
        
        //this code essentially makes the first ace in any hand equal (11) and any after equal (1)
        if ((randomCard == 1) && (handTotal < 11)){
            
            randomCard = 11;
        }
        if ((randomCard == 1) && (handTotal > 12)){
            
            randomCard = 1;
            
        }
        return randomCard;
    }
        

    public int [] holdHand(int hand[]){

        int sum = 0;
        
        for (int i = 0; i < 21; i++){
            
           sum = sum +  hand[i]; 

           
           /*if ((sum > 21) && (hand[i] == 11)) {
            

            sum = sum - 10;
            System.out.println("11 was subtracted");
        }  DOES NOT WORK */
        
        }
        
        //System.out.println("Your hand total is " + sum);
        return hand;
    }

    }

