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
//Cardname method used to label card numbers to a string name
//STRING METHOD
public class CardName {
    
        public String cardType(int cardNumber){
        
        String cardIs = "bust";
//SWITCH STATEMENT       
        switch (cardNumber){
            
            
            case 1: cardIs = ("Ace");
                break;
            case 2: cardIs = ("Two");
                break;
            case 3: cardIs = ("Three");  
                break;
            case 4: cardIs = ("Four");  
                break;
            case 5: cardIs = ("Five"); 
                break;  
            case 6: cardIs = ("Six");
                break;
            case 7: cardIs = ("Seven");
                break;
            case 8: cardIs = ("Eight");
                break;
            case 9: cardIs = ("Nine");
                break;
            case 10: Random randTenCard = new Random();
                     int randomTenCard = randTenCard.nextInt(4);
                     
                     switch(randomTenCard){
                     
                        case 1: cardIs = ("Ten");    
                            break;
                        case 2: cardIs = ("Jack");  
                            break;
                        case 3: cardIs = ("Queen");
                            break;
                        case 4: cardIs = ("King");    
                            break;
                     }
           
        }
        
       return cardIs;
    }
}
